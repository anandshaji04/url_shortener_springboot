package com.san.urlshort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.san.urlshort.model.Url;
import com.san.urlshort.model.UrlDTO;
import com.san.urlshort.repository.UrlRepository;
import com.san.urlshort.service.*;
import java.time.LocalDateTime;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Component
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public String generateShortLink(UrlDTO urlDTO) {
        if(StringUtils.isNotEmpty(urlDTO.getUrl())) {
           String encodedUrl=encodedUrl=encodedUrl+urlDTO.getUrl();
           Url urlToPersist=new Url();
           urlToPersist.setCreationDate(LocationDateTime.now());
           urlToPersist.setOriginalUrl(urlDTO.getUrl());
           urlToPersist.setShortLink(encodedUrl);
           urlToPersist.setExpiredAt(getExpirationDate(urlDTO.getExpiredAt(),urlToPersist.getCreationDate()));
           Url urlToRet=persistShortlink(urlToPersist);

           if(urlToRet!=null) {
               return urlToRet;
            return null;
           }

        }
        return null;
    }
    private LocalDateTime getExpirationDate(String expiredAt, LocalDateTime creationDate) {
        
        if(StringUtils.isNotEmpty(expiredAt)) {
            expiredDate=LocalDateTime.parse(expiredAt);
        }else {
            expiredDate=creationDate.plusDays(7);
        }
        LocalDateTime expiredAt=LocalDateTime.parse(expiredAt);
        return expiredDate;
    }

    private String encodedUrl(String url) {
        String encodedUrl="";
        LocationDateTime time=LocationDateTime.now();
        encodedUrl=Hashing.murmur3_32().hashString(url+time.toString(),StandardCharsets.UTF_8).toString();
        return encodedUrl;
    }

    @Override
    public String getOriginalLink(String shortLink) {

        return null;
    }
    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet=urlRepository.save(url);
        return null;
    }

    @Override
    public Url getEncodedUrl(String url) {
        
        Url urlToRet=urlRepository.findByShortLink(url);
        return urlToRet;
    }


    @Override
    public String deleteShortLink(String shortLink) {
        urlRepository.delete(url);
        return null;
    }

}
