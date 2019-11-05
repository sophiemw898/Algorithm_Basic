//https://leetcode.com/discuss/interview-question/373006
package com.example.idea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/373006
Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

Input:
userSongs = {
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
songGenres = {
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

Output: {
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}

Explanation:
David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 */

public class FavouriteGenresAmazon {
    public Map<String, List<String>> favouriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        //user songToGenre to keep track of the song belong to which genere
        Map<String, String> songToGenre = new HashMap<>();
        for (String genre : songGenres.keySet()) {
            for (String song : songGenres.get(genre)) {
                songToGenre.put(song, genre);
            }
        }

        //use map count to save the times of genres for each user
        Map<String, Integer> count;
        int max;
        for (String user : userSongs.keySet()) {
            count = new HashMap<>();
            max = 0;
            for (String song : userSongs.get(user)) {
                String genre = songToGenre.get(song);
                if (!count.containsKey(genre)) {
                    count.put(genre, 0);
                }
                count.put(genre, count.get(genre) + 1);
                max = Math.max(max, count.get(genre));
            }

            res.put(user, new ArrayList<>());
            for (String genre : count.keySet()) {
                //System.out.println(max);
                if (count.get(genre) == max) {
                    res.get(user).add(genre);
                }
            }
        }

        return  res;
    }
}
