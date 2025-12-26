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

    /* renamed from: d */
    public static int f15800d;

    /* renamed from: e */
    public static int f15801e;

    /* renamed from: b */
    public final Context f15802b;

    /* renamed from: c */
    public boolean f15803c = false;

    public CardPresenter(Context context) {
        this.f15802b = context;
    }

    public boolean getEditMode() {
        return this.f15803c;
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
            boolean z2 = this.f15803c;
            Context context = this.f15802b;
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
            GlideApp.with(context).mo8501load(channelData.getStillImageUrl()).fitCenter().override(313, CARD_HEIGHT).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(imageCardView.getMainImageView());
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        f15801e = ContextCompat.getColor(viewGroup.getContext(), R.color.default_background);
        f15800d = ContextCompat.getColor(viewGroup.getContext(), R.color.selected_background);
        C1066b c1066b = new C1066b(this, viewGroup.getContext(), viewGroup);
        c1066b.setFocusable(true);
        c1066b.setFocusableInTouchMode(true);
        int i = f15801e;
        c1066b.setBackgroundColor(i);
        c1066b.findViewById(R.id.info_field).setBackgroundColor(i);
        return new Presenter.ViewHolder(c1066b);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        imageCardView.setBadgeImage(null);
        imageCardView.setMainImage(null);
    }

    public void setEditMode(boolean z) {
        this.f15803c = z;
    }
}
