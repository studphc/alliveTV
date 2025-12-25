package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.leanback.util.MathUtil;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class PlaybackControlsRow extends Row {

    /* renamed from: d */
    public final Object f5986d;

    /* renamed from: e */
    public Drawable f5987e;

    /* renamed from: f */
    public ObjectAdapter f5988f;

    /* renamed from: g */
    public ObjectAdapter f5989g;

    /* renamed from: h */
    public long f5990h;

    /* renamed from: i */
    public long f5991i;

    /* renamed from: j */
    public long f5992j;

    /* renamed from: k */
    public OnPlaybackProgressCallback f5993k;

    /* loaded from: classes.dex */
    public static class ClosedCaptioningAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        /* renamed from: ON */
        @Deprecated
        public static final int f5994ON = 1;

        public ClosedCaptioningAction(Context context) {
            this(context, PlaybackControlsRow.m1464b(context));
        }

        public ClosedCaptioningAction(Context context, int i) {
            super(androidx.leanback.R.id.lb_control_closed_captioning);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_closed_captioning, context);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.m1463a(bitmapDrawable.getBitmap(), i))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_closed_captioning_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_closed_captioning_disable)});
        }
    }

    /* loaded from: classes.dex */
    public static class FastForwardAction extends MultiAction {
        public FastForwardAction(Context context) {
            this(context, 1);
        }

        public FastForwardAction(Context context, int i) {
            super(androidx.leanback.R.id.lb_control_fast_forward);
            if (i >= 1) {
                Drawable[] drawableArr = new Drawable[i + 1];
                drawableArr[0] = PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_fast_forward, context);
                setDrawables(drawableArr);
                String[] strArr = new String[getActionCount()];
                strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_fast_forward);
                String[] strArr2 = new String[getActionCount()];
                strArr2[0] = strArr[0];
                int i2 = 1;
                while (i2 <= i) {
                    int i3 = i2 + 1;
                    strArr[i2] = context.getResources().getString(androidx.leanback.R.string.lb_control_display_fast_forward_multiplier, Integer.valueOf(i3));
                    strArr2[i2] = context.getResources().getString(androidx.leanback.R.string.lb_playback_controls_fast_forward_multiplier, Integer.valueOf(i3));
                    i2 = i3;
                }
                setLabels(strArr);
                setSecondaryLabels(strArr2);
                addKeyCode(90);
                return;
            }
            throw new IllegalArgumentException("numSpeeds must be > 0");
        }
    }

    /* loaded from: classes.dex */
    public static class HighQualityAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        /* renamed from: ON */
        @Deprecated
        public static final int f5995ON = 1;

        public HighQualityAction(Context context) {
            this(context, PlaybackControlsRow.m1464b(context));
        }

        public HighQualityAction(Context context, int i) {
            super(androidx.leanback.R.id.lb_control_high_quality);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_high_quality, context);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.m1463a(bitmapDrawable.getBitmap(), i))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_high_quality_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_high_quality_disable)});
        }
    }

    /* loaded from: classes.dex */
    public static class MoreActions extends Action {
        public MoreActions(Context context) {
            super(androidx.leanback.R.id.lb_control_more_actions);
            setIcon(context.getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_more));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_more_actions));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class MultiAction extends Action {

        /* renamed from: f */
        public int f5996f;

        /* renamed from: g */
        public Drawable[] f5997g;

        /* renamed from: h */
        public String[] f5998h;

        /* renamed from: i */
        public String[] f5999i;

        public MultiAction(int i) {
            super(i);
        }

        public int getActionCount() {
            Drawable[] drawableArr = this.f5997g;
            if (drawableArr != null) {
                return drawableArr.length;
            }
            String[] strArr = this.f5998h;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        public Drawable getDrawable(int i) {
            Drawable[] drawableArr = this.f5997g;
            if (drawableArr == null) {
                return null;
            }
            return drawableArr[i];
        }

        public int getIndex() {
            return this.f5996f;
        }

        public String getLabel(int i) {
            String[] strArr = this.f5998h;
            if (strArr == null) {
                return null;
            }
            return strArr[i];
        }

        public String getSecondaryLabel(int i) {
            String[] strArr = this.f5999i;
            if (strArr == null) {
                return null;
            }
            return strArr[i];
        }

        public void nextIndex() {
            int i;
            if (this.f5996f < getActionCount() - 1) {
                i = this.f5996f + 1;
            } else {
                i = 0;
            }
            setIndex(i);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.f5997g = drawableArr;
            setIndex(0);
        }

        public void setIndex(int i) {
            this.f5996f = i;
            Drawable[] drawableArr = this.f5997g;
            if (drawableArr != null) {
                setIcon(drawableArr[i]);
            }
            String[] strArr = this.f5998h;
            if (strArr != null) {
                setLabel1(strArr[this.f5996f]);
            }
            String[] strArr2 = this.f5999i;
            if (strArr2 != null) {
                setLabel2(strArr2[this.f5996f]);
            }
        }

        public void setLabels(String[] strArr) {
            this.f5998h = strArr;
            setIndex(0);
        }

        public void setSecondaryLabels(String[] strArr) {
            this.f5999i = strArr;
            setIndex(0);
        }
    }

    /* loaded from: classes.dex */
    public static class OnPlaybackProgressCallback {
        public void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        }

        public void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j) {
        }

        public void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j) {
        }
    }

    /* loaded from: classes.dex */
    public static class PictureInPictureAction extends Action {
        public PictureInPictureAction(Context context) {
            super(androidx.leanback.R.id.lb_control_picture_in_picture);
            setIcon(PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_picture_in_picture, context));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_picture_in_picture));
            addKeyCode(171);
        }
    }

    /* loaded from: classes.dex */
    public static class PlayPauseAction extends MultiAction {
        public static final int INDEX_PAUSE = 1;
        public static final int INDEX_PLAY = 0;

        @Deprecated
        public static final int PAUSE = 1;

        @Deprecated
        public static final int PLAY = 0;

        public PlayPauseAction(Context context) {
            super(androidx.leanback.R.id.lb_control_play_pause);
            setDrawables(new Drawable[]{PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_play, context), PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_pause, context)});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_play), context.getString(androidx.leanback.R.string.lb_playback_controls_pause)});
            addKeyCode(85);
            addKeyCode(126);
            addKeyCode(127);
        }
    }

    /* loaded from: classes.dex */
    public static class RepeatAction extends MultiAction {

        @Deprecated
        public static final int ALL = 1;
        public static final int INDEX_ALL = 1;
        public static final int INDEX_NONE = 0;
        public static final int INDEX_ONE = 2;

        @Deprecated
        public static final int NONE = 0;

        @Deprecated
        public static final int ONE = 2;

        public RepeatAction(Context context) {
            this(context, PlaybackControlsRow.m1464b(context));
        }

        public RepeatAction(Context context, int i) {
            this(context, i, i);
        }

        public RepeatAction(Context context, int i, int i2) {
            super(androidx.leanback.R.id.lb_control_repeat);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_repeat, context);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_repeat_one, context);
            setDrawables(new Drawable[]{bitmapDrawable, bitmapDrawable == null ? null : new BitmapDrawable(context.getResources(), PlaybackControlsRow.m1463a(bitmapDrawable.getBitmap(), i)), bitmapDrawable2 != null ? new BitmapDrawable(context.getResources(), PlaybackControlsRow.m1463a(bitmapDrawable2.getBitmap(), i2)) : null});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_all), context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_one), context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_none)});
        }
    }

    /* loaded from: classes.dex */
    public static class RewindAction extends MultiAction {
        public RewindAction(Context context) {
            this(context, 1);
        }

        public RewindAction(Context context, int i) {
            super(androidx.leanback.R.id.lb_control_fast_rewind);
            if (i >= 1) {
                Drawable[] drawableArr = new Drawable[i + 1];
                drawableArr[0] = PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_rewind, context);
                setDrawables(drawableArr);
                String[] strArr = new String[getActionCount()];
                strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_rewind);
                String[] strArr2 = new String[getActionCount()];
                strArr2[0] = strArr[0];
                int i2 = 1;
                while (i2 <= i) {
                    int i3 = i2 + 1;
                    String string = context.getResources().getString(androidx.leanback.R.string.lb_control_display_rewind_multiplier, Integer.valueOf(i3));
                    strArr[i2] = string;
                    strArr[i2] = string;
                    strArr2[i2] = context.getResources().getString(androidx.leanback.R.string.lb_playback_controls_rewind_multiplier, Integer.valueOf(i3));
                    i2 = i3;
                }
                setLabels(strArr);
                setSecondaryLabels(strArr2);
                addKeyCode(89);
                return;
            }
            throw new IllegalArgumentException("numSpeeds must be > 0");
        }
    }

    /* loaded from: classes.dex */
    public static class ShuffleAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        /* renamed from: ON */
        @Deprecated
        public static final int f6000ON = 1;

        public ShuffleAction(Context context) {
            this(context, PlaybackControlsRow.m1464b(context));
        }

        public ShuffleAction(Context context, int i) {
            super(androidx.leanback.R.id.lb_control_shuffle);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_shuffle, context);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.m1463a(bitmapDrawable.getBitmap(), i))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_shuffle_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_shuffle_disable)});
        }
    }

    /* loaded from: classes.dex */
    public static class SkipNextAction extends Action {
        public SkipNextAction(Context context) {
            super(androidx.leanback.R.id.lb_control_skip_next);
            setIcon(PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_skip_next, context));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_skip_next));
            addKeyCode(87);
        }
    }

    /* loaded from: classes.dex */
    public static class SkipPreviousAction extends Action {
        public SkipPreviousAction(Context context) {
            super(androidx.leanback.R.id.lb_control_skip_previous);
            setIcon(PlaybackControlsRow.m1465c(androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_skip_previous, context));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_skip_previous));
            addKeyCode(88);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ThumbsAction extends MultiAction {
        public static final int INDEX_OUTLINE = 1;
        public static final int INDEX_SOLID = 0;

        @Deprecated
        public static final int OUTLINE = 1;

        @Deprecated
        public static final int SOLID = 0;

        public ThumbsAction(int i, Context context, int i2, int i3) {
            super(i);
            setDrawables(new Drawable[]{PlaybackControlsRow.m1465c(i2, context), PlaybackControlsRow.m1465c(i3, context)});
        }
    }

    /* loaded from: classes.dex */
    public static class ThumbsDownAction extends ThumbsAction {
        public ThumbsDownAction(Context context) {
            super(androidx.leanback.R.id.lb_control_thumbs_down, context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_down, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_down_outline);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_down);
            strArr[1] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_down_outline);
            setLabels(strArr);
        }
    }

    /* loaded from: classes.dex */
    public static class ThumbsUpAction extends ThumbsAction {
        public ThumbsUpAction(Context context) {
            super(androidx.leanback.R.id.lb_control_thumbs_up, context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_up, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_up_outline);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_up);
            strArr[1] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_up_outline);
            setLabels(strArr);
        }
    }

    public PlaybackControlsRow(Object obj) {
        this.f5986d = obj;
    }

    /* renamed from: a */
    public static Bitmap m1463a(Bitmap bitmap, int i) {
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Canvas canvas = new Canvas(copy);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, RecyclerView.f7068F0, RecyclerView.f7068F0, paint);
        return copy;
    }

    /* renamed from: b */
    public static int m1464b(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackControlsIconHighlightColor, typedValue, true)) {
            return typedValue.data;
        }
        return context.getResources().getColor(androidx.leanback.R.color.lb_playback_icon_highlight_no_theme);
    }

    /* renamed from: c */
    public static Drawable m1465c(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackControlsActionIcons, typedValue, false)) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(typedValue.data, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons);
        Drawable drawable = obtainStyledAttributes.getDrawable(i);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public Action getActionForKeyCode(int i) {
        Action actionForKeyCode = getActionForKeyCode(getPrimaryActionsAdapter(), i);
        return actionForKeyCode != null ? actionForKeyCode : getActionForKeyCode(getSecondaryActionsAdapter(), i);
    }

    public long getBufferedPosition() {
        return this.f5992j;
    }

    @Deprecated
    public int getBufferedProgress() {
        return MathUtil.safeLongToInt(getBufferedPosition());
    }

    @Deprecated
    public long getBufferedProgressLong() {
        return this.f5992j;
    }

    public long getCurrentPosition() {
        return this.f5991i;
    }

    @Deprecated
    public int getCurrentTime() {
        return MathUtil.safeLongToInt(getCurrentTimeLong());
    }

    @Deprecated
    public long getCurrentTimeLong() {
        return this.f5991i;
    }

    public long getDuration() {
        return this.f5990h;
    }

    public final Drawable getImageDrawable() {
        return this.f5987e;
    }

    public final Object getItem() {
        return this.f5986d;
    }

    public final ObjectAdapter getPrimaryActionsAdapter() {
        return this.f5988f;
    }

    public final ObjectAdapter getSecondaryActionsAdapter() {
        return this.f5989g;
    }

    @Deprecated
    public int getTotalTime() {
        return MathUtil.safeLongToInt(getTotalTimeLong());
    }

    @Deprecated
    public long getTotalTimeLong() {
        return this.f5990h;
    }

    public void setBufferedPosition(long j) {
        if (this.f5992j != j) {
            this.f5992j = j;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.f5993k;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onBufferedPositionChanged(this, j);
            }
        }
    }

    @Deprecated
    public void setBufferedProgress(int i) {
        setBufferedPosition(i);
    }

    @Deprecated
    public void setBufferedProgressLong(long j) {
        setBufferedPosition(j);
    }

    public void setCurrentPosition(long j) {
        if (this.f5991i != j) {
            this.f5991i = j;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.f5993k;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onCurrentPositionChanged(this, j);
            }
        }
    }

    @Deprecated
    public void setCurrentTime(int i) {
        setCurrentTimeLong(i);
    }

    @Deprecated
    public void setCurrentTimeLong(long j) {
        setCurrentPosition(j);
    }

    public void setDuration(long j) {
        if (this.f5990h != j) {
            this.f5990h = j;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.f5993k;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onDurationChanged(this, j);
            }
        }
    }

    public final void setImageBitmap(Context context, Bitmap bitmap) {
        this.f5987e = new BitmapDrawable(context.getResources(), bitmap);
    }

    public final void setImageDrawable(Drawable drawable) {
        this.f5987e = drawable;
    }

    public void setOnPlaybackProgressChangedListener(OnPlaybackProgressCallback onPlaybackProgressCallback) {
        this.f5993k = onPlaybackProgressCallback;
    }

    public final void setPrimaryActionsAdapter(ObjectAdapter objectAdapter) {
        this.f5988f = objectAdapter;
    }

    public final void setSecondaryActionsAdapter(ObjectAdapter objectAdapter) {
        this.f5989g = objectAdapter;
    }

    @Deprecated
    public void setTotalTime(int i) {
        setDuration(i);
    }

    @Deprecated
    public void setTotalTimeLong(long j) {
        setDuration(j);
    }

    public PlaybackControlsRow() {
    }

    public Action getActionForKeyCode(ObjectAdapter objectAdapter, int i) {
        if (objectAdapter != this.f5988f && objectAdapter != this.f5989g) {
            throw new IllegalArgumentException("Invalid adapter");
        }
        for (int i2 = 0; i2 < objectAdapter.size(); i2++) {
            Action action = (Action) objectAdapter.get(i2);
            if (action.respondsToKeyCode(i)) {
                return action;
            }
        }
        return null;
    }
}
