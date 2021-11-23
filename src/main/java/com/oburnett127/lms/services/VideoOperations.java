package com.oburnett127.lms.services;

import com.oburnett127.lms.model.Video;

import java.util.List;

public interface VideoOperations {

	Video createVideo(Video Video);

	List<Video> getVideos();

	Video getVideo(Integer id);

	Video updateVideo(Video Video);

	void deleteVideo(Integer id);

}