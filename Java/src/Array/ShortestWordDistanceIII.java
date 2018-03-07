package Array;

import java.util.ArrayList;

/**
 * Created by jianmei on 6/22/16.
 */
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {

		if ( words.length < 2 )
			return 0;

		int size = words.length;
		int shortest = Integer.MAX_VALUE;
		int w1 = -1, w2 = -1;

		for ( int i = 0; i < size; i++ )
		{
			if ( words[i].equals(word1) )
			{
				w1 = i;
				if ( w2 != -1 )
					shortest = Integer.min( w1 - w2, shortest );
			}

			if ( words[i].equals(word2) )
			{
				w2 = i;
				if ( w1 != -1 && w2 - w1 != 0 ) // SMART
					shortest = Integer.min( w2 - w1, shortest );
			}
		}

		return shortest;
	}

}
