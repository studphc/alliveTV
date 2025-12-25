package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.C1827t9;
import p000.RunnableC1104d;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {

    /* renamed from: e0 */
    public final Handler f4613e0 = new Handler();

    /* renamed from: f0 */
    public final RunnableC1104d f4614f0 = new RunnableC1104d(25, this);

    /* renamed from: g0 */
    public final C1827t9 f4615g0 = new C1827t9(1, this);

    /* renamed from: h0 */
    public ListAdapter f4616h0;

    /* renamed from: i0 */
    public ListView f4617i0;

    /* renamed from: j0 */
    public View f4618j0;

    /* renamed from: k0 */
    public TextView f4619k0;

    /* renamed from: l0 */
    public View f4620l0;

    /* renamed from: m0 */
    public View f4621m0;

    /* renamed from: n0 */
    public CharSequence f4622n0;

    /* renamed from: o0 */
    public boolean f4623o0;

    @Nullable
    public ListAdapter getListAdapter() {
        return this.f4616h0;
    }

    @NonNull
    public ListView getListView() {
        m1210l();
        return this.f4617i0;
    }

    public long getSelectedItemId() {
        m1210l();
        return this.f4617i0.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        m1210l();
        return this.f4617i0.getSelectedItemPosition();
    }

    /* renamed from: l */
    public final void m1210l() {
        if (this.f4617i0 != null) {
            return;
        }
        View view = getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.f4617i0 = (ListView) view;
            } else {
                TextView textView = (TextView) view.findViewById(16711681);
                this.f4619k0 = textView;
                if (textView == null) {
                    this.f4618j0 = view.findViewById(R.id.empty);
                } else {
                    textView.setVisibility(8);
                }
                this.f4620l0 = view.findViewById(16711682);
                this.f4621m0 = view.findViewById(16711683);
                View findViewById = view.findViewById(R.id.list);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                ListView listView = (ListView) findViewById;
                this.f4617i0 = listView;
                View view2 = this.f4618j0;
                if (view2 != null) {
                    listView.setEmptyView(view2);
                } else {
                    CharSequence charSequence = this.f4622n0;
                    if (charSequence != null) {
                        this.f4619k0.setText(charSequence);
                        this.f4617i0.setEmptyView(this.f4619k0);
                    }
                }
            }
            this.f4623o0 = true;
            this.f4617i0.setOnItemClickListener(this.f4615g0);
            ListAdapter listAdapter = this.f4616h0;
            if (listAdapter != null) {
                this.f4616h0 = null;
                setListAdapter(listAdapter);
            } else if (this.f4620l0 != null) {
                m1211m(false, false);
            }
            this.f4613e0.post(this.f4614f0);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    /* renamed from: m */
    public final void m1211m(boolean z, boolean z2) {
        m1210l();
        View view = this.f4620l0;
        if (view != null) {
            if (this.f4623o0 == z) {
                return;
            }
            this.f4623o0 = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                    this.f4621m0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                } else {
                    view.clearAnimation();
                    this.f4621m0.clearAnimation();
                }
                this.f4620l0.setVisibility(8);
                this.f4621m0.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                this.f4621m0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
            } else {
                view.clearAnimation();
                this.f4621m0.clearAnimation();
            }
            this.f4620l0.setVisibility(0);
            this.f4621m0.setVisibility(8);
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f4613e0.removeCallbacks(this.f4614f0);
        this.f4617i0 = null;
        this.f4623o0 = false;
        this.f4621m0 = null;
        this.f4620l0 = null;
        this.f4618j0 = null;
        this.f4619k0 = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i, long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m1210l();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        m1210l();
        TextView textView = this.f4619k0;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.f4622n0 == null) {
                this.f4617i0.setEmptyView(this.f4619k0);
            }
            this.f4622n0 = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z;
        boolean z2 = false;
        if (this.f4616h0 != null) {
            z = true;
        } else {
            z = false;
        }
        this.f4616h0 = listAdapter;
        ListView listView = this.f4617i0;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.f4623o0 && !z) {
                if (requireView().getWindowToken() != null) {
                    z2 = true;
                }
                m1211m(true, z2);
            }
        }
    }

    public void setListShown(boolean z) {
        m1211m(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m1211m(z, false);
    }

    public void setSelection(int i) {
        m1210l();
        this.f4617i0.setSelection(i);
    }
}
