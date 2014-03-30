package com.example.team9.stores;

import java.io.File;

public class toUpload {

	String title, description, game;
	File videoFile, thumbnailFile;
	
	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getGame() {

		return game;
	}

	public void setGame(String game) {

		this.game = game;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public File getVideoFile() {

		return videoFile;
	}

	public void setvideoFile(File videoFile) {

		this.videoFile = videoFile;
	}

	public File getthumbnailFile() {

		return thumbnailFile;
	}

	public void setthumbnailFile(File thumbnailFile) {

		this.thumbnailFile = thumbnailFile;
	}

}
