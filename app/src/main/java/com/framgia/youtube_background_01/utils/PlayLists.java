package com.framgia.youtube_background_01.utils;

import android.support.annotation.StringDef;

@StringDef({
        PlayLists.TOP_MUSIC_TITLE, PlayLists.TOP_MUSIC, PlayLists.VIOLIN_COVER_TITLE,
        PlayLists.VIOLIN_COVER, PlayLists.DANCE_TITLE, PlayLists.DANCE, PlayLists.DEEP_HOUSE_TITLE,
        PlayLists.DEEP_HOUSE,
})

public @interface PlayLists {
    String TOP_MUSIC_TITLE = "Top music 2019";
    String TOP_MUSIC = "PLP9GgDwtdPPQEejYdDz6EJhdEZbTuO5Lz";
    String VIOLIN_COVER_TITLE = "Violin Cover";
    String VIOLIN_COVER = "PL9KFzTqQB8xx01l3e7bIow8jgEBCUi664";
    String DANCE_TITLE = "Dance";
    String DANCE = "PLCUUHvdbD7yPUho9V9Gv_AYuDQa9rmp7y";
    String DEEP_HOUSE_TITLE = "Deep house";
    String DEEP_HOUSE = "PLjzeyhEA84sS6ogo2mXWdcTrL2HRfJUv8";
}
