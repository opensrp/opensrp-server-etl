package org.opensrp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.opensrp.acl.entity.Location;
import org.opensrp.acl.entity.LocationTag;
import org.opensrp.acl.service.impl.LocationServiceImpl;
import org.opensrp.acl.service.impl.LocationTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		return "location/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "location/add.html", method = RequestMethod.GET)
	public ModelAndView saveLocation(ModelMap model, HttpSession session) {
		
		model.addAttribute("location", new Location());
		
		List<Location> locations = locationTagServiceImpl.findAll("Location");
		Map<Integer, String> parentLocationMap = new HashMap<Integer, String>();
		for (Location location : locations) {
			parentLocationMap.put(location.getId(), location.getName());
			
		}
		
		List<LocationTag> locationTags = locationTagServiceImpl.findAll("LocationTag");
		Map<Integer, String> locationsTagMap = new HashMap<Integer, String>();
		for (LocationTag locationTag : locationTags) {
			locationsTagMap.put(locationTag.getId(), locationTag.getName());
			
		}
		model.addAttribute("locationsTag", locationsTagMap);
		model.addAttribute("parentLocation", parentLocationMap);
		return new ModelAndView("location/add", "command", location);
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/location/add.html", method = RequestMethod.POST)
	public ModelAndView saveLocation(@ModelAttribute("location") @Valid Location location, BindingResult binding,
	                                 ModelMap model, HttpSession session) throws Exception {
		
		locationServiceImpl.save(location);
		return new ModelAndView("redirect:/location.html");
		
	}
	
}
