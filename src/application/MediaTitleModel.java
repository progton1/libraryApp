package application;

public abstract class MediaTitleModel {

	
	abstract void addTitle(String title,
			String releaseYear, String desc);
	
	abstract void removeTitle();
	
	abstract void editTitle();
	
	abstract void getMediaInfo();
	
	
}
