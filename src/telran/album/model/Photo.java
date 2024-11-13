package telran.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo {
    private int AlbumId;
    private  int photoId;
    private String title;
    private String url;
    private LocalDateTime date;

    public Photo(int albumId, int photoId, String title, String url, LocalDateTime date) {
        AlbumId = albumId;
        this.photoId = photoId;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public int getAlbumId() {
        return AlbumId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "AlbumId=" + AlbumId +
                ", photoId='" + photoId + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo photo)) return false;

        return AlbumId == photo.AlbumId && Objects.equals(photoId, photo.photoId) && Objects.equals(title, photo.title) && Objects.equals(url, photo.url) && Objects.equals(date, photo.date);
    }

    @Override
    public int hashCode() {
        int result = AlbumId;
        result = 31 * result + Objects.hashCode(photoId);
        return result;
    }
}
