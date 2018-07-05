/**
 * @author proshanto
 * */

package org.opensrp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.opensrp.acl.entity.Location;
import org.opensrp.acl.service.impl.LocationServiceImpl;
import org.opensrp.acl.service.impl.LocationTagServiceImpl;
import org.opensrp.common.util.TreeNode;
import org.opensrp.web.util.LocationTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocationController {
	
	Map<Integer, String> loctrese = new HashMap<Integer, String>();
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private LocationTagServiceImpl locationTagServiceImpl;
	
	@Autowired
	private Location location;
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ROLE')")
	@RequestMapping(value = "location.html", method = RequestMethod.GET)
	public String locationList(Model model, HttpSession session) {
		List<Location> locations = locationServiceImpl.findAll("Location");
		session.setAttribute("locations", locations);
		model.addAttribute("locations", locations);
		LocationTree locationTree = new LocationTree();
		locationTree.buildTreeFromList(locations);
		Map<String, TreeNode<String, Location>> lotree = locationTree.getLocationsHierarchy();
		/*System.err.println("Size:" + lotree.size());
		for (Map.Entry<String, TreeNode<String, Location>> entry : lotree.entrySet()) {
			TreeNode<String, Location> treeNode = entry.getValue();
			
			Map<String, TreeNode<String, Location>> children = treeNode.getChildren();
			System.err.println("Parent: " + treeNode.getNode().getName());
			if (children != null) {
				System.err.println("Child size:" + children.size());
			}
			
		}
		System.err.println("...............");*/
		Map<Integer, String> loctree = new HashMap<Integer, String>();
		treeTraverse(lotree, loctree);
		
		//		/System.err.println("OK");
		//System.err.println("lotree" + new Gson().toJson(lotree));
		//System.err.println("OK");
		model.addAttribute("lotree", lotree);
		return "location/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ROLE')")
	@RequestMapping(value = "location/hierarchy.html", method = RequestMethod.GET)
	public String locationHierarchy(Model model, HttpSession session) throws JSONException {
		String parentIndication = "#";
		String parentKey = "parent";
		JSONArray data = locationServiceImpl.getLocationDataAsJson(parentIndication, parentKey);
		System.err.println("Data:" + data);
		session.setAttribute("locatationTreeData", data);
		return "location/hierarchy";
	}
	
	public Map<Integer, String> treeTraverse(Map<String, TreeNode<String, Location>> lotree, Map<Integer, String> loctree) {
		TreeNode<String, Location> treeNode = null;
		
		int i = 0;
		String div = "";
		for (Map.Entry<String, TreeNode<String, Location>> entry : lotree.entrySet()) {
			i++;
			treeNode = entry.getValue();
			Map<String, TreeNode<String, Location>> children = treeNode.getChildren();
			
			//System.err.println("Parent" + treeNode.getParent() + "child: " + i + "->" + treeNode.getNode().getName());
			loctrese.put(treeNode.getNode().getId(), treeNode.getNode().getName());
			if (children != null) {
				
				treeTraverse(children, loctree);
				
			} else {
				i = 0;
				
				//System.err.println("-----------------------");
			}
			
		}
		return loctrese;
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "location/add.html", method = RequestMethod.GET)
	public ModelAndView saveLocation(ModelMap model, HttpSession session) throws JSONException {
		
		model.addAttribute("location", new Location());
		locationServiceImpl.setSessionAttribute(session, location);
		String parentIndication = "-1";
		String parentKey = "parentid";
		JSONArray data = locationServiceImpl.getLocationDataAsJson(parentIndication, parentKey);
		session.setAttribute("locatationTreeData", data);
		return new ModelAndView("location/add", "command", location);
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/location/add.html", method = RequestMethod.POST)
	public ModelAndView saveLocation(@RequestParam(value = "parentLocation", required = false) int parentLocationId,
	                                 @RequestParam(value = "locationTag") int tagId,
	                                 @ModelAttribute("location") @Valid Location location, BindingResult binding,
	                                 ModelMap model, HttpSession session) throws Exception {
		location.setName(location.getName().trim());
		if (!locationServiceImpl.locationExists(location)) {
			locationServiceImpl.save(locationServiceImpl.setCreatorParentLocationTagAttributeInLocation(location,
			    parentLocationId, tagId));
		} else {
			location = locationServiceImpl.setCreatorParentLocationTagAttributeInLocation(location, parentLocationId, tagId);
			locationServiceImpl.setSessionAttribute(session, location);
			locationServiceImpl.setModelAttribute(model, location);
			return new ModelAndView("/location/add");
		}
		
		return new ModelAndView("redirect:/location.html");
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "location/{id}/edit.html", method = RequestMethod.GET)
	public ModelAndView editLocation(ModelMap model, HttpSession session, @PathVariable("id") int id) {
		Location location = locationServiceImpl.findById(id, "id", Location.class);
		model.addAttribute("id", id);
		model.addAttribute("location", location);
		locationServiceImpl.setSessionAttribute(session, location);
		return new ModelAndView("location/edit", "command", location);
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/location/{id}/edit.html", method = RequestMethod.POST)
	public ModelAndView editLocation(@RequestParam(value = "parentLocation") int parentLocationId,
	                                 @RequestParam(value = "locationTag") int tagId,
	                                 @ModelAttribute("location") @Valid Location location, BindingResult binding,
	                                 ModelMap model, HttpSession session, @PathVariable("id") int id) throws Exception {
		location.setId(id);
		location.setName(location.getName().trim());
		if (locationServiceImpl.sameEditedNameAndActualName(id, location.getName())) {
			locationServiceImpl.update(locationServiceImpl.setCreatorParentLocationTagAttributeInLocation(location,
			    parentLocationId, tagId));
		} else {
			if (!locationServiceImpl.locationExists(location)) {
				locationServiceImpl.update(locationServiceImpl.setCreatorParentLocationTagAttributeInLocation(location,
				    parentLocationId, tagId));
			} else {
				location = locationServiceImpl.setCreatorParentLocationTagAttributeInLocation(location, parentLocationId,
				    tagId);
				locationServiceImpl.setSessionAttribute(session, location);
				locationServiceImpl.setModelAttribute(model, location);
				return new ModelAndView("/location/edit");
			}
		}
		return new ModelAndView("redirect:/location.html");
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ROLE')")
	@RequestMapping(value = "location/search.html", method = RequestMethod.GET)
	public String locationSearch(Model model, HttpSession session, @RequestParam String name) throws JSONException {
		System.err.println("name:" + name);
		List<Location> locations = locationServiceImpl.getAllByKeysWithALlMatches(name);
		
		session.setAttribute("searchedLocation", locations);
		return "location/search";
	}
}
