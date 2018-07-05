/**
 * @author proshanto
 * */

package org.opensrp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.google.gson.Gson;

@Controller
public class LocationController {
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private LocationTagServiceImpl locationTagServiceImpl;
	
	@Autowired
	private Location location;
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ROLE')")
	@RequestMapping(value = "location.html", method = RequestMethod.GET)
	public String locationList(Model model) {
		List<Location> locations = locationTagServiceImpl.findAll("Location");
		model.addAttribute("locations", locations);
		LocationTree locationTree = new LocationTree();
		locationTree.buildTreeFromList(locations);
		Map<String, TreeNode<String, Location>> lotree = locationTree.getLocationsHierarchy();
		System.err.println("lotree" + new Gson().toJson(lotree));
		return "location/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "location/add.html", method = RequestMethod.GET)
	public ModelAndView saveLocation(ModelMap model, HttpSession session) {
		
		model.addAttribute("location", new Location());
		locationServiceImpl.setSessionAttribute(session, location);
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
}
