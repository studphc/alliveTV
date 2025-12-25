package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class PlaybackTransportRowPresenter extends PlaybackRowPresenter {

    /* renamed from: e */
    public float f6031e = 0.01f;

    /* renamed from: f */
    public int f6032f = 0;

    /* renamed from: g */
    public int f6033g = 0;

    /* renamed from: h */
    public boolean f6034h;

    /* renamed from: i */
    public boolean f6035i;

    /* renamed from: j */
    public Presenter f6036j;

    /* renamed from: k */
    public final C0376q f6037k;

    /* renamed from: l */
    public final C0376q f6038l;

    /* renamed from: m */
    public OnActionClickedListener f6039m;

    /* loaded from: classes.dex */
    public class ViewHolder extends PlaybackRowPresenter.ViewHolder implements PlaybackSeekUi {

        /* renamed from: A */
        public C0372p f6040A;

        /* renamed from: B */
        public final C0351j2 f6041B;

        /* renamed from: C */
        public final C0351j2 f6042C;

        /* renamed from: D */
        public Presenter.ViewHolder f6043D;

        /* renamed from: E */
        public Object f6044E;

        /* renamed from: F */
        public PlaybackControlsRow.PlayPauseAction f6045F;

        /* renamed from: G */
        public int f6046G;

        /* renamed from: H */
        public PlaybackSeekUi.Client f6047H;

        /* renamed from: I */
        public boolean f6048I;

        /* renamed from: J */
        public PlaybackSeekDataProvider f6049J;

        /* renamed from: K */
        public long[] f6050K;

        /* renamed from: L */
        public int f6051L;

        /* renamed from: M */
        public final C0355k2 f6052M;

        /* renamed from: N */
        public final C0359l2 f6053N;

        /* renamed from: n */
        public final Presenter.ViewHolder f6055n;

        /* renamed from: o */
        public final ImageView f6056o;

        /* renamed from: p */
        public final ViewGroup f6057p;

        /* renamed from: q */
        public final ViewGroup f6058q;

        /* renamed from: r */
        public final ViewGroup f6059r;

        /* renamed from: s */
        public final TextView f6060s;

        /* renamed from: t */
        public final TextView f6061t;

        /* renamed from: u */
        public final SeekBar f6062u;

        /* renamed from: v */
        public final ThumbsBar f6063v;

        /* renamed from: w */
        public long f6064w;

        /* renamed from: x */
        public long f6065x;

        /* renamed from: y */
        public final StringBuilder f6066y;

        /* renamed from: z */
        public C0372p f6067z;

        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.leanback.widget.j2, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v3, types: [androidx.leanback.widget.j2, java.lang.Object] */
        public ViewHolder(View view, Presenter presenter) {
            super(view);
            Presenter.ViewHolder onCreateViewHolder;
            this.f6064w = Long.MIN_VALUE;
            this.f6065x = Long.MIN_VALUE;
            this.f6066y = new StringBuilder();
            this.f6041B = new Object();
            this.f6042C = new Object();
            this.f6046G = -1;
            this.f6052M = new C0355k2(this);
            this.f6053N = new C0359l2(this);
            this.f6056o = (ImageView) view.findViewById(androidx.leanback.R.id.image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.description_dock);
            this.f6057p = viewGroup;
            this.f6061t = (TextView) view.findViewById(androidx.leanback.R.id.current_time);
            this.f6060s = (TextView) view.findViewById(androidx.leanback.R.id.total_time);
            SeekBar seekBar = (SeekBar) view.findViewById(androidx.leanback.R.id.playback_progress);
            this.f6062u = seekBar;
            seekBar.setOnClickListener(new ViewOnClickListenerC0363m2(this));
            seekBar.setOnKeyListener(new ViewOnKeyListenerC0367n2(this));
            seekBar.setAccessibilitySeekListener(new C0371o2(this));
            seekBar.setMax(Integer.MAX_VALUE);
            this.f6058q = (ViewGroup) view.findViewById(androidx.leanback.R.id.controls_dock);
            this.f6059r = (ViewGroup) view.findViewById(androidx.leanback.R.id.secondary_controls_dock);
            if (presenter == null) {
                onCreateViewHolder = null;
            } else {
                onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            }
            this.f6055n = onCreateViewHolder;
            if (onCreateViewHolder != null) {
                viewGroup.addView(onCreateViewHolder.view);
            }
            this.f6063v = (ThumbsBar) view.findViewById(androidx.leanback.R.id.thumbs_row);
        }

        /* renamed from: a */
        public final void m1472a() {
            if (!isSelected()) {
                return;
            }
            if (this.f6043D == null) {
                if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                }
            } else if (getOnItemViewSelectedListener() != null) {
                getOnItemViewSelectedListener().onItemSelected(this.f6043D, this.f6044E, this, getRow());
            }
        }

        /* renamed from: b */
        public final Presenter m1473b(boolean z) {
            ObjectAdapter secondaryActionsAdapter;
            if (z) {
                secondaryActionsAdapter = ((PlaybackControlsRow) getRow()).getPrimaryActionsAdapter();
            } else {
                secondaryActionsAdapter = ((PlaybackControlsRow) getRow()).getSecondaryActionsAdapter();
            }
            Object obj = null;
            if (secondaryActionsAdapter == null) {
                return null;
            }
            if (secondaryActionsAdapter.getPresenterSelector() instanceof ControlButtonPresenterSelector) {
                return ((ControlButtonPresenterSelector) secondaryActionsAdapter.getPresenterSelector()).getSecondaryPresenter();
            }
            if (secondaryActionsAdapter.size() > 0) {
                obj = secondaryActionsAdapter.get(0);
            }
            return secondaryActionsAdapter.getPresenter(obj);
        }

        /* renamed from: c */
        public final void m1474c(long j) {
            int i;
            if (j != this.f6065x) {
                this.f6065x = j;
                onSetCurrentPositionLabel(j);
            }
            if (!this.f6048I) {
                long j2 = this.f6064w;
                if (j2 > 0) {
                    i = (int) ((this.f6065x / j2) * 2.147483647E9d);
                } else {
                    i = 0;
                }
                this.f6062u.setProgress(i);
            }
        }

        /* renamed from: d */
        public final boolean m1475d() {
            long[] jArr;
            if (this.f6048I) {
                return true;
            }
            PlaybackSeekUi.Client client = this.f6047H;
            if (client == null || !client.isSeekEnabled() || this.f6064w <= 0) {
                return false;
            }
            this.f6048I = true;
            this.f6047H.onSeekStarted();
            PlaybackSeekDataProvider playbackSeekDataProvider = this.f6047H.getPlaybackSeekDataProvider();
            this.f6049J = playbackSeekDataProvider;
            if (playbackSeekDataProvider != null) {
                jArr = playbackSeekDataProvider.getSeekPositions();
            } else {
                jArr = null;
            }
            this.f6050K = jArr;
            if (jArr != null) {
                int binarySearch = Arrays.binarySearch(jArr, this.f6064w);
                if (binarySearch >= 0) {
                    this.f6051L = binarySearch + 1;
                } else {
                    this.f6051L = (-1) - binarySearch;
                }
            } else {
                this.f6051L = 0;
            }
            this.f6067z.view.setVisibility(8);
            this.f6040A.view.setVisibility(4);
            this.f6055n.view.setVisibility(4);
            this.f6063v.setVisibility(0);
            return true;
        }

        /* renamed from: e */
        public final void m1476e(boolean z) {
            if (!this.f6048I) {
                return;
            }
            this.f6048I = false;
            this.f6047H.onSeekFinished(z);
            PlaybackSeekDataProvider playbackSeekDataProvider = this.f6049J;
            if (playbackSeekDataProvider != null) {
                playbackSeekDataProvider.reset();
            }
            this.f6046G = -1;
            ThumbsBar thumbsBar = this.f6063v;
            thumbsBar.clearThumbBitmaps();
            this.f6049J = null;
            this.f6050K = null;
            this.f6051L = 0;
            this.f6067z.view.setVisibility(0);
            this.f6040A.view.setVisibility(0);
            this.f6055n.view.setVisibility(0);
            thumbsBar.setVisibility(4);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00cf A[ADDED_TO_REGION, LOOP:0: B:21:0x00cf->B:22:0x00d1, LOOP_START, PHI: r11
          0x00cf: PHI (r11v13 int) = (r11v12 int), (r11v14 int) binds: [B:20:0x00cd, B:22:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00eb A[LOOP:1: B:25:0x00e3->B:27:0x00eb, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00f1 A[EDGE_INSN: B:28:0x00f1->B:29:0x00f1 BREAK  A[LOOP:1: B:25:0x00e3->B:27:0x00eb], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00f6 A[LOOP:2: B:30:0x00f4->B:31:0x00f6, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[ADDED_TO_REGION, LOOP:3: B:33:0x00d9->B:34:0x00db, LOOP_START, PHI: r10
          0x00d9: PHI (r10v9 int) = (r10v8 int), (r10v10 int) binds: [B:20:0x00cd, B:34:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m1477f(boolean z) {
            int min;
            int i;
            int i2;
            int i3;
            long j = this.f6065x;
            int i4 = this.f6051L;
            long j2 = 0;
            if (i4 > 0) {
                int i5 = 0;
                int binarySearch = Arrays.binarySearch(this.f6050K, 0, i4, j);
                if (z) {
                    if (binarySearch >= 0) {
                        if (binarySearch < this.f6051L - 1) {
                            binarySearch++;
                            j2 = this.f6050K[binarySearch];
                        } else {
                            j2 = this.f6064w;
                        }
                    } else {
                        int i6 = (-1) - binarySearch;
                        if (i6 <= this.f6051L - 1) {
                            j2 = this.f6050K[i6];
                            binarySearch = i6;
                        } else {
                            j2 = this.f6064w;
                            if (i6 > 0) {
                                binarySearch = (-2) - binarySearch;
                            }
                            binarySearch = 0;
                        }
                    }
                    if (this.f6046G != binarySearch) {
                        ThumbsBar thumbsBar = this.f6063v;
                        int childCount = thumbsBar.getChildCount();
                        if (childCount >= 0 && (childCount & 1) != 0) {
                            int i7 = childCount / 2;
                            int max = Math.max(binarySearch - i7, 0);
                            int min2 = Math.min(binarySearch + i7, this.f6051L - 1);
                            int i8 = this.f6046G;
                            if (i8 < 0) {
                                i = max;
                            } else {
                                if (binarySearch > i8) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                int max2 = Math.max(i8 - i7, 0);
                                int min3 = Math.min(this.f6046G + i7, this.f6051L - 1);
                                if (z) {
                                    int max3 = Math.max(min3 + 1, max);
                                    for (int i9 = max; i9 <= max3 - 1; i9++) {
                                        thumbsBar.setThumbBitmap((i9 - binarySearch) + i7, thumbsBar.getThumbBitmap((i9 - this.f6046G) + i7));
                                    }
                                    i = max3;
                                } else {
                                    min = Math.min(max2 - 1, min2);
                                    for (int i10 = min2; i10 >= min + 1; i10--) {
                                        thumbsBar.setThumbBitmap((i10 - binarySearch) + i7, thumbsBar.getThumbBitmap((i10 - this.f6046G) + i7));
                                    }
                                    i = max;
                                    this.f6046G = binarySearch;
                                    C0359l2 c0359l2 = this.f6053N;
                                    if (!z) {
                                        while (i <= min) {
                                            this.f6049J.getThumbnail(i, c0359l2);
                                            i++;
                                        }
                                    } else {
                                        while (min >= i) {
                                            this.f6049J.getThumbnail(min, c0359l2);
                                            min--;
                                        }
                                    }
                                    while (true) {
                                        i2 = this.f6046G;
                                        if (i5 < (i7 - i2) + max) {
                                            break;
                                        }
                                        thumbsBar.setThumbBitmap(i5, null);
                                        i5++;
                                    }
                                    for (i3 = ((i7 + min2) - i2) + 1; i3 < childCount; i3++) {
                                        thumbsBar.setThumbBitmap(i3, null);
                                    }
                                }
                            }
                            min = min2;
                            this.f6046G = binarySearch;
                            C0359l2 c0359l22 = this.f6053N;
                            if (!z) {
                            }
                            while (true) {
                                i2 = this.f6046G;
                                if (i5 < (i7 - i2) + max) {
                                }
                                thumbsBar.setThumbBitmap(i5, null);
                                i5++;
                            }
                            while (i3 < childCount) {
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    }
                } else if (binarySearch >= 0) {
                    if (binarySearch > 0) {
                        binarySearch--;
                        j2 = this.f6050K[binarySearch];
                        if (this.f6046G != binarySearch) {
                        }
                    }
                    binarySearch = 0;
                    if (this.f6046G != binarySearch) {
                    }
                } else {
                    if ((-1) - binarySearch > 0) {
                        binarySearch = (-2) - binarySearch;
                        j2 = this.f6050K[binarySearch];
                        if (this.f6046G != binarySearch) {
                        }
                    }
                    binarySearch = 0;
                    if (this.f6046G != binarySearch) {
                    }
                }
            } else {
                long defaultSeekIncrement = PlaybackTransportRowPresenter.this.getDefaultSeekIncrement() * ((float) this.f6064w);
                if (!z) {
                    defaultSeekIncrement = -defaultSeekIncrement;
                }
                long j3 = j + defaultSeekIncrement;
                long j4 = this.f6064w;
                if (j3 > j4) {
                    j2 = j4;
                } else if (j3 >= 0) {
                    j2 = j3;
                }
            }
            this.f6062u.setProgress((int) ((j2 / this.f6064w) * 2.147483647E9d));
            this.f6047H.onSeekPositionChanged(j2);
        }

        public final TextView getCurrentPositionView() {
            return this.f6061t;
        }

        public final Presenter.ViewHolder getDescriptionViewHolder() {
            return this.f6055n;
        }

        public final TextView getDurationView() {
            return this.f6060s;
        }

        public void onSetCurrentPositionLabel(long j) {
            TextView textView = this.f6061t;
            if (textView != null) {
                StringBuilder sb = this.f6066y;
                PlaybackTransportRowPresenter.m1471c(j, sb);
                textView.setText(sb.toString());
            }
        }

        public void onSetDurationLabel(long j) {
            TextView textView = this.f6060s;
            if (textView != null) {
                StringBuilder sb = this.f6066y;
                PlaybackTransportRowPresenter.m1471c(j, sb);
                textView.setText(sb.toString());
            }
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi
        public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
            this.f6047H = client;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.leanback.widget.l, java.lang.Object] */
    public PlaybackTransportRowPresenter() {
        ?? obj = new Object();
        C0343h2 c0343h2 = new C0343h2(this);
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        int i = androidx.leanback.R.layout.lb_control_bar;
        C0376q c0376q = new C0376q(i);
        this.f6037k = c0376q;
        c0376q.f6397e = false;
        C0376q c0376q2 = new C0376q(i);
        this.f6038l = c0376q2;
        c0376q2.f6397e = false;
        c0376q.f6395c = obj;
        c0376q2.f6395c = obj;
        c0376q.f6394b = c0343h2;
        c0376q2.f6394b = c0343h2;
    }

    /* renamed from: c */
    public static void m1471c(long j, StringBuilder sb) {
        sb.setLength(0);
        if (j < 0) {
            sb.append("--");
            return;
        }
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j3 / 60;
        long j5 = j2 - (j3 * 60);
        long j6 = j3 - (60 * j4);
        if (j4 > 0) {
            sb.append(j4);
            sb.append(':');
            if (j6 < 10) {
                sb.append('0');
            }
        }
        sb.append(j6);
        sb.append(':');
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        int color;
        int color2;
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_playback_transport_controls_row, viewGroup, false), this.f6036j);
        C0376q c0376q = this.f6037k;
        ViewGroup viewGroup2 = viewHolder.f6058q;
        viewHolder.f6067z = (C0372p) c0376q.onCreateViewHolder(viewGroup2);
        if (this.f6034h) {
            color = this.f6032f;
        } else {
            Context context = viewGroup2.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackProgressPrimaryColor, typedValue, true)) {
                color = context.getResources().getColor(typedValue.resourceId);
            } else {
                color = context.getResources().getColor(androidx.leanback.R.color.lb_playback_progress_color_no_theme);
            }
        }
        SeekBar seekBar = viewHolder.f6062u;
        seekBar.setProgressColor(color);
        if (this.f6035i) {
            color2 = this.f6033g;
        } else {
            Context context2 = viewGroup2.getContext();
            TypedValue typedValue2 = new TypedValue();
            if (context2.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackProgressSecondaryColor, typedValue2, true)) {
                color2 = context2.getResources().getColor(typedValue2.resourceId);
            } else {
                color2 = context2.getResources().getColor(androidx.leanback.R.color.lb_playback_progress_secondary_color_no_theme);
            }
        }
        seekBar.setSecondaryProgressColor(color2);
        viewGroup2.addView(viewHolder.f6067z.view);
        C0376q c0376q2 = this.f6038l;
        ViewGroup viewGroup3 = viewHolder.f6059r;
        C0372p c0372p = (C0372p) c0376q2.onCreateViewHolder(viewGroup3);
        viewHolder.f6040A = c0372p;
        viewGroup3.addView(c0372p.view);
        ((PlaybackTransportRowView) viewHolder.view.findViewById(androidx.leanback.R.id.transport_row)).setOnUnhandledKeyListener(new C0347i2(viewHolder));
        return viewHolder;
    }

    public float getDefaultSeekIncrement() {
        return this.f6031e;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.f6039m;
    }

    @ColorInt
    public int getProgressColor() {
        return this.f6032f;
    }

    @ColorInt
    public int getSecondaryProgressColor() {
        return this.f6033g;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Object item = playbackControlsRow.getItem();
        ViewGroup viewGroup = viewHolder2.f6057p;
        if (item == null) {
            viewGroup.setVisibility(8);
        } else {
            viewGroup.setVisibility(0);
            Presenter.ViewHolder viewHolder3 = viewHolder2.f6055n;
            if (viewHolder3 != null) {
                this.f6036j.onBindViewHolder(viewHolder3, playbackControlsRow.getItem());
            }
        }
        Drawable imageDrawable = playbackControlsRow.getImageDrawable();
        ImageView imageView = viewHolder2.f6056o;
        if (imageDrawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setImageDrawable(playbackControlsRow.getImageDrawable());
        ObjectAdapter primaryActionsAdapter = playbackControlsRow.getPrimaryActionsAdapter();
        C0351j2 c0351j2 = viewHolder2.f6041B;
        c0351j2.f43a = primaryActionsAdapter;
        c0351j2.f44b = viewHolder2.m1473b(true);
        c0351j2.f6313d = viewHolder2;
        this.f6037k.onBindViewHolder(viewHolder2.f6067z, c0351j2);
        ObjectAdapter secondaryActionsAdapter = playbackControlsRow.getSecondaryActionsAdapter();
        C0351j2 c0351j22 = viewHolder2.f6042C;
        c0351j22.f43a = secondaryActionsAdapter;
        c0351j22.f44b = viewHolder2.m1473b(false);
        c0351j22.f6313d = viewHolder2;
        this.f6038l.onBindViewHolder(viewHolder2.f6040A, c0351j22);
        long duration = playbackControlsRow.getDuration();
        if (viewHolder2.f6064w != duration) {
            viewHolder2.f6064w = duration;
            viewHolder2.onSetDurationLabel(duration);
        }
        viewHolder2.m1474c(playbackControlsRow.getCurrentPosition());
        viewHolder2.f6062u.setSecondaryProgress((int) ((playbackControlsRow.getBufferedPosition() / viewHolder2.f6064w) * 2.147483647E9d));
        playbackControlsRow.setOnPlaybackProgressChangedListener(viewHolder2.f6052M);
    }

    public void onProgressBarClicked(ViewHolder viewHolder) {
        if (viewHolder != null) {
            if (viewHolder.f6045F == null) {
                viewHolder.f6045F = new PlaybackControlsRow.PlayPauseAction(viewHolder.view.getContext());
            }
            if (viewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.getOnItemViewClickedListener().onItemClicked(viewHolder, viewHolder.f6045F, viewHolder, viewHolder.getRow());
            }
            OnActionClickedListener onActionClickedListener = this.f6039m;
            if (onActionClickedListener != null) {
                onActionClickedListener.onActionClicked(viewHolder.f6045F);
            }
        }
    }

    @Override // androidx.leanback.widget.PlaybackRowPresenter
    public void onReappear(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.view.hasFocus()) {
            viewHolder2.f6062u.requestFocus();
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.f6036j;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).f6055n);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.f6036j;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).f6055n);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z) {
        super.onRowViewSelected(viewHolder, z);
        if (z) {
            ((ViewHolder) viewHolder).m1472a();
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Presenter.ViewHolder viewHolder3 = viewHolder2.f6055n;
        if (viewHolder3 != null) {
            this.f6036j.onUnbindViewHolder(viewHolder3);
        }
        this.f6037k.onUnbindViewHolder(viewHolder2.f6067z);
        this.f6038l.onUnbindViewHolder(viewHolder2.f6040A);
        playbackControlsRow.setOnPlaybackProgressChangedListener(null);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setDefaultSeekIncrement(float f) {
        this.f6031e = f;
    }

    public void setDescriptionPresenter(Presenter presenter) {
        this.f6036j = presenter;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.f6039m = onActionClickedListener;
    }

    public void setProgressColor(@ColorInt int i) {
        this.f6032f = i;
        this.f6034h = true;
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.f6033g = i;
        this.f6035i = true;
    }
}
