package com.hisona.allive;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class CardPresenter extends Presenter {
    public static final int CARD_HEIGHT = 176;
    public static final int CARD_WIDTH = 313;
    public static int d;
    public static int e;
    public final Context b;
    public boolean c = false;

    public CardPresenter(Context context) {
        this.b = context;
    }

    public boolean getEditMode() {
        return this.c;
    }

    @Override // androidx.leanback.widget.Presenter
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ChannelData channelData = (ChannelData) obj;
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        if (channelData.getStillImageUrl() != null) {
            ArrayList<EPGData> epg = channelData.getEPG();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
            Date time = calendar.getTime();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= epg.size()) {
                    break;
                }
                if (time.compareTo(epg.get(i).getEndTime()) < 0) {
                    channelData.setProgramName(epg.get(i).getProgramName());
                    z = epg.get(i).isAdultContent().booleanValue();
                    channelData.setProgramName(epg.get(i).getProgramName());
                    break;
                }
                i++;
            }
            if (channelData.getProgramName() != null && (channelData.getProgramName().equals("") || z)) {
                imageCardView.setTitleText(channelData.getTitle());
            } else {
                imageCardView.setTitleText(channelData.getTitle() + " - " + channelData.getProgramName());
            }
            imageCardView.setMainImageDimensions(313, CARD_HEIGHT);
            boolean z2 = this.c;
            Context context = this.b;
            if (z2 && imageCardView.isSelected()) {
                imageCardView.setBackground(ContextCompat.getDrawable(context, R.drawable.image_border));
            } else {
                imageCardView.setBackground(ContextCompat.getDrawable(context, R.drawable.image_borderless));
            }
            int favorite = channelData.getFavorite();
            if (favorite == 0) {
                imageCardView.setBadgeImage(null);
            } else if (favorite == 1) {
                imageCardView.setBadgeImage(imageCardView.getResources().getDrawable(R.drawable.star_icon_24, null));
            } else if (favorite == 2) {
                imageCardView.setBadgeImage(imageCardView.getResources().getDrawable(R.drawable.wavve_icon_24, null));
            } else if (favorite == 3) {
                imageCardView.setBadgeImage(imageCardView.getResources().getDrawable(R.drawable.tving_icon_24, null));
            }
            GlideApp.with(context).mo54load(channelData.getStillImageUrl()).fitCenter().override(313, CARD_HEIGHT).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(imageCardView.getMainImageView());
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        e = ContextCompat.getColor(viewGroup.getContext(), R.color.default_background);
        d = ContextCompat.getColor(viewGroup.getContext(), R.color.selected_background);
        b bVar = new b(this, viewGroup.getContext(), viewGroup);
        bVar.setFocusable(true);
        bVar.setFocusableInTouchMode(true);
        int i = e;
        bVar.setBackgroundColor(i);
        bVar.findViewById(R.id.info_field).setBackgroundColor(i);
        return new Presenter.ViewHolder(bVar);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        imageCardView.setBadgeImage(null);
        imageCardView.setMainImage(null);
    }

    public void setEditMode(boolean z) {
        this.c = z;
    }
}
