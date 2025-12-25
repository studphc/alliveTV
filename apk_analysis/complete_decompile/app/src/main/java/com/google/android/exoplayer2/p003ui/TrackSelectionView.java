package com.google.android.exoplayer2.p003ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.C1808sr;
import p000.ViewOnClickListenerC1109d4;
import p000.gv2;

/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: o */
    public static final /* synthetic */ int f12302o = 0;

    /* renamed from: a */
    public final int f12303a;

    /* renamed from: b */
    public final LayoutInflater f12304b;

    /* renamed from: c */
    public final CheckedTextView f12305c;

    /* renamed from: d */
    public final CheckedTextView f12306d;

    /* renamed from: e */
    public final ViewOnClickListenerC1109d4 f12307e;

    /* renamed from: f */
    public final ArrayList f12308f;

    /* renamed from: g */
    public final HashMap f12309g;

    /* renamed from: h */
    public boolean f12310h;

    /* renamed from: i */
    public boolean f12311i;

    /* renamed from: j */
    public TrackNameProvider f12312j;

    /* renamed from: k */
    public CheckedTextView[][] f12313k;

    /* renamed from: l */
    public boolean f12314l;

    /* renamed from: m */
    public C1808sr f12315m;

    /* renamed from: n */
    public TrackSelectionListener f12316n;

    /* loaded from: classes.dex */
    public interface TrackSelectionListener {
        void onTrackSelectionChanged(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public static Map<TrackGroup, TrackSelectionOverride> filterOverrides(Map<TrackGroup, TrackSelectionOverride> map, List<Tracks.Group> list, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            TrackSelectionOverride trackSelectionOverride = map.get(list.get(i).getMediaTrackGroup());
            if (trackSelectionOverride != null && (z || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public final void m2955a() {
        boolean z;
        this.f12305c.setChecked(this.f12314l);
        boolean z2 = this.f12314l;
        HashMap hashMap = this.f12309g;
        if (!z2 && hashMap.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f12306d.setChecked(z);
        for (int i = 0; i < this.f12313k.length; i++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(((Tracks.Group) this.f12308f.get(i)).getMediaTrackGroup());
            int i2 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f12313k[i];
                if (i2 < checkedTextViewArr.length) {
                    if (trackSelectionOverride != null) {
                        this.f12313k[i][i2].setChecked(trackSelectionOverride.trackIndices.contains(Integer.valueOf(((gv2) Assertions.checkNotNull(checkedTextViewArr[i2].getTag())).f17851b)));
                    } else {
                        checkedTextViewArr[i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    /* renamed from: b */
    public final void m2956b() {
        boolean z;
        boolean z2;
        int i;
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f12308f;
        boolean isEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f12306d;
        CheckedTextView checkedTextView2 = this.f12305c;
        if (isEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.f12313k = new CheckedTextView[arrayList.size()];
        if (this.f12311i && arrayList.size() > 1) {
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Tracks.Group group = (Tracks.Group) arrayList.get(i2);
            if (this.f12310h && group.isAdaptiveSupported()) {
                z2 = true;
            } else {
                z2 = false;
            }
            CheckedTextView[][] checkedTextViewArr = this.f12313k;
            int i3 = group.length;
            checkedTextViewArr[i2] = new CheckedTextView[i3];
            gv2[] gv2VarArr = new gv2[i3];
            for (int i4 = 0; i4 < group.length; i4++) {
                gv2VarArr[i4] = new gv2(group, i4);
            }
            C1808sr c1808sr = this.f12315m;
            if (c1808sr != null) {
                Arrays.sort(gv2VarArr, c1808sr);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                LayoutInflater layoutInflater = this.f12304b;
                if (i5 == 0) {
                    addView(layoutInflater.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
                }
                if (!z2 && !z) {
                    i = R.layout.simple_list_item_single_choice;
                } else {
                    i = R.layout.simple_list_item_multiple_choice;
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate(i, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f12303a);
                TrackNameProvider trackNameProvider = this.f12312j;
                gv2 gv2Var = gv2VarArr[i5];
                checkedTextView3.setText(trackNameProvider.getTrackName(gv2Var.f17850a.getTrackFormat(gv2Var.f17851b)));
                checkedTextView3.setTag(gv2VarArr[i5]);
                if (group.isTrackSupported(i5)) {
                    checkedTextView3.setFocusable(true);
                    checkedTextView3.setOnClickListener(this.f12307e);
                } else {
                    checkedTextView3.setFocusable(false);
                    checkedTextView3.setEnabled(false);
                }
                this.f12313k[i2][i5] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        m2955a();
    }

    public boolean getIsDisabled() {
        return this.f12314l;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.f12309g;
    }

    public void init(List<Tracks.Group> list, boolean z, Map<TrackGroup, TrackSelectionOverride> map, @Nullable Comparator<Format> comparator, @Nullable TrackSelectionListener trackSelectionListener) {
        C1808sr c1808sr;
        this.f12314l = z;
        if (comparator == null) {
            c1808sr = null;
        } else {
            c1808sr = new C1808sr(comparator, 3);
        }
        this.f12315m = c1808sr;
        this.f12316n = trackSelectionListener;
        ArrayList arrayList = this.f12308f;
        arrayList.clear();
        arrayList.addAll(list);
        HashMap hashMap = this.f12309g;
        hashMap.clear();
        hashMap.putAll(filterOverrides(map, list, this.f12311i));
        m2956b();
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.f12310h != z) {
            this.f12310h = z;
            m2956b();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.f12311i != z) {
            this.f12311i = z;
            if (!z) {
                HashMap hashMap = this.f12309g;
                if (hashMap.size() > 1) {
                    Map<TrackGroup, TrackSelectionOverride> filterOverrides = filterOverrides(hashMap, this.f12308f, false);
                    hashMap.clear();
                    hashMap.putAll(filterOverrides);
                }
            }
            m2956b();
        }
    }

    public void setShowDisableOption(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        this.f12305c.setVisibility(i);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.f12312j = (TrackNameProvider) Assertions.checkNotNull(trackNameProvider);
        m2956b();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f12303a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f12304b = from;
        ViewOnClickListenerC1109d4 viewOnClickListenerC1109d4 = new ViewOnClickListenerC1109d4(9, this);
        this.f12307e = viewOnClickListenerC1109d4;
        this.f12312j = new DefaultTrackNameProvider(getResources());
        this.f12308f = new ArrayList();
        this.f12309g = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f12305c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(viewOnClickListenerC1109d4);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f12306d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(viewOnClickListenerC1109d4);
        addView(checkedTextView2);
    }
}
