package com.uzakura.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;


@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class Header {
     @SlingObject
     private Resource currentResource;
     @SlingObject ResourceResolver resolver;
      String title = "";
    @PostConstruct
    protected void init(){
      if(currentResource !=null){
        Resource menuResource = currentResource.getChild("bottomLinks");
        if (menuResource != null) {
         Resource itemOneResource = menuResource.getChild("item0");
         if (itemOneResource !=null) {
            title = itemOneResource.getValueMap().get("title" , String.class);
         }
        }
      }

    }
     public String getTitle() {
        return title;
    }
}
