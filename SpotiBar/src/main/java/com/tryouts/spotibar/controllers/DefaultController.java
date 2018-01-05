package com.tryouts.spotibar.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.tryouts.spotibar.dao.RecommendationSearchCriteria;
import com.tryouts.spotibar.utils.RecommendationRequestUtil;
import com.wrapper.spotify.models.Track;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.tryouts.spotibar.dao.SearchCriteria;
import com.wrapper.spotify.exceptions.WebApiException;

import javax.validation.Valid;

@Controller
public class DefaultController {


    @GetMapping(value="/")
    public String showSearch(Model model) {
        model.addAttribute("criteria", new SearchCriteria());
        return "Main";
    }

    @PostMapping(value="/")
    public String processSearch(@Valid @ModelAttribute("criteria") SearchCriteria criteria, BindingResult bindingResult,
                              Model model) throws IOException, WebApiException {

        if(bindingResult.hasErrors()) {
            return "/Main";
        }

        RecommendationSearchCriteria recommendationSearchCriteria =
                new RecommendationSearchCriteria.RecommendationCriteriaBuilder()
                .searchCriteria(criteria)
                .build();

        RecommendationRequestUtil requestUtil = new RecommendationRequestUtil(recommendationSearchCriteria);

        ArrayList<Track> searchResults = (ArrayList<Track>) requestUtil.getRecommendationRequest().get();

        model.addAttribute("searchResults", searchResults);

        return "SearchResults";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
