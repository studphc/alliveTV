package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AbstractC1726qj;
import p000.fu0;
import p000.gu0;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    public final ArrayList f4585a;

    /* renamed from: b */
    public FrameLayout f4586b;

    /* renamed from: c */
    public Context f4587c;

    /* renamed from: d */
    public FragmentManager f4588d;

    /* renamed from: e */
    public int f4589e;

    /* renamed from: f */
    public TabHost.OnTabChangeListener f4590f;

    /* renamed from: g */
    public gu0 f4591g;

    /* renamed from: h */
    public boolean f4592h;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public String f4593a;

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentTabHost.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" curTab=");
            return AbstractC1726qj.m7061q(sb, this.f4593a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f4593a);
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.f4585a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.inflatedId}, 0, 0);
        this.f4589e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* renamed from: a */
    public final FragmentTransaction m1204a(FragmentTransaction fragmentTransaction, String str) {
        gu0 gu0Var;
        Fragment fragment;
        ArrayList arrayList = this.f4585a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                gu0Var = (gu0) arrayList.get(i);
                if (gu0Var.f17840a.equals(str)) {
                    break;
                }
                i++;
            } else {
                gu0Var = null;
                break;
            }
        }
        if (this.f4591g != gu0Var) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f4588d.beginTransaction();
            }
            gu0 gu0Var2 = this.f4591g;
            if (gu0Var2 != null && (fragment = gu0Var2.f17843d) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (gu0Var != null) {
                Fragment fragment2 = gu0Var.f17843d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f4588d.getFragmentFactory().instantiate(this.f4587c.getClassLoader(), gu0Var.f17841b.getName());
                    gu0Var.f17843d = instantiate;
                    instantiate.setArguments(gu0Var.f17842c);
                    fragmentTransaction.add(this.f4589e, gu0Var.f17843d, gu0Var.f17840a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.f4591g = gu0Var;
        }
        return fragmentTransaction;
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new fu0(this.f4587c));
        String tag = tabSpec.getTag();
        gu0 gu0Var = new gu0(bundle, tag, cls);
        if (this.f4592h) {
            Fragment findFragmentByTag = this.f4588d.findFragmentByTag(tag);
            gu0Var.f17843d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.f4588d.beginTransaction();
                beginTransaction.detach(gu0Var.f17843d);
                beginTransaction.commit();
            }
        }
        this.f4585a.add(gu0Var);
        addTab(tabSpec);
    }

    /* renamed from: b */
    public final void m1205b() {
        if (this.f4586b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f4589e);
            this.f4586b = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f4589e);
            }
        }
    }

    /* renamed from: c */
    public final void m1206c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, RecyclerView.f7068F0));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, RecyclerView.f7068F0));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f4586b = frameLayout2;
            frameLayout2.setId(this.f4589e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        ArrayList arrayList = this.f4585a;
        int size = arrayList.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            gu0 gu0Var = (gu0) arrayList.get(i);
            Fragment findFragmentByTag = this.f4588d.findFragmentByTag(gu0Var.f17840a);
            gu0Var.f17843d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (gu0Var.f17840a.equals(currentTabTag)) {
                    this.f4591g = gu0Var;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f4588d.beginTransaction();
                    }
                    fragmentTransaction.detach(gu0Var.f17843d);
                }
            }
        }
        this.f4592h = true;
        FragmentTransaction m1204a = m1204a(fragmentTransaction, currentTabTag);
        if (m1204a != null) {
            m1204a.commit();
            this.f4588d.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4592h = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f4593a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, androidx.fragment.app.FragmentTabHost$SavedState, android.os.Parcelable] */
    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f4593a = getCurrentTabTag();
        return baseSavedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction m1204a;
        if (this.f4592h && (m1204a = m1204a(null, str)) != null) {
            m1204a.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f4590f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f4590f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        m1206c(context);
        super.setup();
        this.f4587c = context;
        this.f4588d = fragmentManager;
        m1205b();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4585a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f4589e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        m1206c(context);
        super.setup();
        this.f4587c = context;
        this.f4588d = fragmentManager;
        this.f4589e = i;
        m1205b();
        this.f4586b.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
