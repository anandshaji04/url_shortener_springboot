package com.san.urlshort.model;

import java.time.LocalDateTime;

public class UrlResponseDTO {

    private String originalUrl;
    private String shortUrl;
    private LocalDateTime expiredAt;

    public UrlResponseDTO() {
    }

    public UrlResponseDTO(String originalUrl, String shortUrl, LocalDateTime expiredAt) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.expiredAt = expiredAt;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

}
