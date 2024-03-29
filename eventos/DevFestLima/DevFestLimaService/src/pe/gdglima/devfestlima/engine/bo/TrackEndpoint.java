package pe.gdglima.devfestlima.engine.bo;

import pe.gdglima.devfestlima.engine.bo.PMF;

import com.google.api.server.spi.config.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "trackendpoint")
public class TrackEndpoint {

  /**
   * This method lists all the entities inserted in datastore.
   * It uses HTTP GET method.
   *
   * @return List of all entities persisted.
   */
  @SuppressWarnings({"cast", "unchecked"})
  public List<Track> listTrack() {
    PersistenceManager mgr = getPersistenceManager();
    List<Track> result = new ArrayList<Track>();
    try{
      Query query = mgr.newQuery(Track.class);
      for (Object obj : (List<Object>) query.execute()) {
        result.add(((Track) obj));
      }
    } finally {
      mgr.close();
    }
    return result;
  }

  /**
   * This method gets the entity having primary key id. It uses HTTP GET method.
   *
   * @param id the primary key of the java bean.
   * @return The entity with primary key id.
   */
  public Track getTrack(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    Track track  = null;
    try {
      track = mgr.getObjectById(Track.class, id);
    } finally {
      mgr.close();
    }
    return track;
  }

  /**
   * This inserts the entity into App Engine datastore.
   * It uses HTTP POST method.
   *
   * @param track the entity to be inserted.
   * @return The inserted entity.
   */
  public Track insertTrack(Track track) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      mgr.makePersistent(track);
    } finally {
      mgr.close();
    }
    return track;
  }

  /**
   * This method is used for updating a entity.
   * It uses HTTP PUT method.
   *
   * @param track the entity to be updated.
   * @return The updated entity.
   */
  public Track updateTrack(Track track) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      mgr.makePersistent(track);
    } finally {
      mgr.close();
    }
    return track;
  }

  /**
   * This method removes the entity with primary key id.
   * It uses HTTP DELETE method.
   *
   * @param id the primary key of the entity to be deleted.
   * @return The deleted entity.
   */
  public Track removeTrack(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
     Track track  = null;
    try {
      track = mgr.getObjectById(Track.class, id);
      mgr.deletePersistent(track);
    } finally {
      mgr.close();
    }
    return track;
  }

  private static PersistenceManager getPersistenceManager() {
    return PMF.get().getPersistenceManager();
  }

}
