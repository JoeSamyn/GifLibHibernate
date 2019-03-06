package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GifDao {

    List<Gif> findAll();
    Gif findById(Long Id);
    void save(Gif gif);
    void deleteGif(Gif gif);
}
