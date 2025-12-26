package androidx.leanback.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public abstract class PlaybackRowPresenter extends RowPresenter {

    /* loaded from: classes.dex */
    public static class ViewHolder extends RowPresenter.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public void onReappear(@NonNull RowPresenter.ViewHolder viewHolder) {
    }
}
