package telran.album.dao;

import telran.album.model.Photo;

import java.time.LocalDate;
import java.util.Arrays;

public class AlbumImpl implements Album {
    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        //
        if (photo == null || photos.length == size || (getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null)) {
            return false;
        }
        photos[size++] = photo;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        Photo toRemove = null;
        if (getPhotoFromAlbum(photoId, albumId) != null) {
            for (int i = 0; i < size; i++) {
                if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                    toRemove = photos[i];
                    System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                    photos[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        Photo toUpdate = null;
        if (getPhotoFromAlbum(photoId, albumId) != null) {
            for (int i = 0; i < size; i++) {
                if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                    toUpdate = photos[i];
                    toUpdate.setUrl(url);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        //
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        Photo[] fromAlbum = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbumId() == albumId) {
                fromAlbum[j] = photos[i];
                j++;
            }
        }
        return Arrays.copyOf(fromAlbum, j);
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        Photo[] betweenDates = new Photo[size];
        int j = 0;

        for (int i = 0; i < size; i++) {
            if (photos[i].getDate().toLocalDate().compareTo(dateFrom) >= 0 && photos[i].getDate().toLocalDate().compareTo(dateTo) < 0) {
                betweenDates[j] = photos[i];
                j++;
            }
        }

        return Arrays.copyOf(betweenDates, j);
    }

    @Override
    public int size() {
        //
        return size;
    }
}
