package Design;

import java.util.*;

/**
 * Created by JMYE on 9/13/16.
 */
public class DesignTwitter {
    private static int timeStamp = 0;

    // used to find if user exist
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            next = null;
        }
    }

    public class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet new_post = new Tweet(id);
            new_post.next = tweet_head;
            tweet_head = new_post;
        }
    }

    public DesignTwitter() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId,u);
        }
        userMap.get(userId).post(tweetId);
    }

    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this
    // heap before we get the 10 most recent tweet.

    public List<Integer> getNewsFeed (int userId) {
        List<Integer> rst = new LinkedList<>();

        if(!userMap.containsKey(userId)) return rst;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(users.size(),(a,b)->(b.time - a.time));
        for(int user: users) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) {
                tweetHeap.add(t);
            }
        }

        int topK = 0;
        while(!tweetHeap.isEmpty() && topK < 10) {
            Tweet t = tweetHeap.poll();
            rst.add(t.id);
            topK++;
            if (t.next != null) {
                tweetHeap.add(t.next);
            }
        }

        return rst;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] argu) {
        DesignTwitter test = new DesignTwitter();
        test.postTweet(1,1);
        test.postTweet(2,3);
        test.follow(1,2);
        List<Integer> topFeeds = test.getNewsFeed(1);

        for (int i = 0; i < topFeeds.size(); i++) {
            System.out.println(topFeeds.get(i));
        }
    }
}
