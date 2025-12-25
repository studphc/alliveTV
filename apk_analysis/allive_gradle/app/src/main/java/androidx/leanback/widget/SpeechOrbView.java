package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.leanback.widget.SearchOrbView;

/* loaded from: classes.dex */
public class SpeechOrbView extends SearchOrbView {

    /* renamed from: t */
    public final float f6216t;

    /* renamed from: u */
    public SearchOrbView.Colors f6217u;

    /* renamed from: v */
    public SearchOrbView.Colors f6218v;

    /* renamed from: w */
    public int f6219w;

    /* renamed from: x */
    public boolean f6220x;

    public SpeechOrbView(Context context) {
        this(context, null);
    }

    @Override // androidx.leanback.widget.SearchOrbView
    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_speech_orb;
    }

    public void setListeningOrbColors(SearchOrbView.Colors colors) {
        this.f6217u = colors;
    }

    public void setNotListeningOrbColors(SearchOrbView.Colors colors) {
        this.f6218v = colors;
    }

    public void setSoundLevel(int i) {
        if (!this.f6220x) {
            return;
        }
        int i2 = this.f6219w;
        if (i > i2) {
            this.f6219w = ((i - i2) / 2) + i2;
        } else {
            this.f6219w = (int) (i2 * 0.7f);
        }
        float focusedZoom = (((this.f6216t - getFocusedZoom()) * this.f6219w) / 100.0f) + 1.0f;
        View view = this.f6156c;
        view.setScaleX(focusedZoom);
        view.setScaleY(focusedZoom);
    }

    public void showListening() {
        setOrbColors(this.f6217u);
        setOrbIcon(getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_search_mic));
        m1484a(true);
        enableOrbColorAnimation(false);
        View view = this.f6156c;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.f6219w = 0;
        this.f6220x = true;
    }

    public void showNotListening() {
        setOrbColors(this.f6218v);
        setOrbIcon(getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_search_mic_out));
        m1484a(hasFocus());
        View view = this.f6156c;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.f6220x = false;
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6219w = 0;
        this.f6220x = false;
        Resources resources = context.getResources();
        this.f6216t = resources.getFraction(androidx.leanback.R.fraction.lb_search_bar_speech_orb_max_level_zoom, 1, 1);
        this.f6218v = new SearchOrbView.Colors(resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording), resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording_pulsed), resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording_icon));
        int i2 = androidx.leanback.R.color.lb_speech_orb_recording;
        this.f6217u = new SearchOrbView.Colors(resources.getColor(i2), resources.getColor(i2), 0);
        showNotListening();
    }
}
