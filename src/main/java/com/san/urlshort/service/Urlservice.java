package com.san.urlshort.service;

import org.springframework.stereotype.Service;

import com.san.urlshort.model.Url;
import com.san.urlshort.model.UrlDTO;

@Service
public interface Urlservice {


    public Url generateShortlink(UrlDTO urlDTO);
    public Url persistShortlink(Url url);
    public Url getEncodedLink(String shortlink);
    public void deleteShortlink(Url url);

}
