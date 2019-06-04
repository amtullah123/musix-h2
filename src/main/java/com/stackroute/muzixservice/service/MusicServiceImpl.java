package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{

private MusicRepository musicRepository;
@Autowired
    public MusicServiceImpl(MusicRepository musicRepository)
{
    this.musicRepository=musicRepository;
}
@Override
    public Music saveTrack(Music music)
{
    Music savedTrack=musicRepository.save(music);
    return savedTrack;
}
@Override
public List<Music> getAllTracks()
{
return (List<Music>) musicRepository.findAll();
}
//@Override
//public Music displayTrackByName(String tname)
//{
//    return musicRepository.displayTrackByName(tname);
//}

@Override
    public Music displayTrackById(int tid)
    {
        return musicRepository.findById(tid).get();
    }


//    @Override
//    public List<Music> displayTrack() {
//        return musicRepository.findAll();
//    }


@Override
    public void deleteTrack(int trackId) {
        musicRepository.deleteById(trackId);

    }

  @Override
    public Music updateTrackComments(Music music, int tid) throws TrackNotFoundException {
        if(!musicRepository.existsById(tid))
        {
            throw new TrackNotFoundException("track is not found");
        }
        Music music1=musicRepository.findById(tid).get();
        music1.setComments(music.getComments());
        return musicRepository.save(music1);
    }
}






