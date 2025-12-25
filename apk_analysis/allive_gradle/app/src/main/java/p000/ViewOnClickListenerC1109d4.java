package p000;

import android.os.Message;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.OnboardingFragment;
import androidx.leanback.app.OnboardingSupportFragment;
import androidx.leanback.widget.C0413z1;
import androidx.leanback.widget.SearchBar;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.p003ui.TrackSelectionView;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import com.hisona.allive.ErrorFragment;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: d4 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC1109d4 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f16236a;

    /* renamed from: b */
    public final /* synthetic */ Object f16237b;

    public /* synthetic */ ViewOnClickListenerC1109d4(int i, Object obj) {
        this.f16236a = i;
        this.f16237b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4;
        boolean z;
        switch (this.f16236a) {
            case 0:
                ((ActionMode) this.f16237b).finish();
                return;
            case 1:
                ActionBarDrawerToggle actionBarDrawerToggle = (ActionBarDrawerToggle) this.f16237b;
                if (actionBarDrawerToggle.f581f) {
                    DrawerLayout drawerLayout = actionBarDrawerToggle.f577b;
                    int drawerLockMode = drawerLayout.getDrawerLockMode(GravityCompat.START);
                    if (drawerLayout.isDrawerVisible(GravityCompat.START) && drawerLockMode != 2) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return;
                    } else {
                        if (drawerLockMode != 1) {
                            drawerLayout.openDrawer(GravityCompat.START);
                            return;
                        }
                        return;
                    }
                }
                View.OnClickListener onClickListener = actionBarDrawerToggle.f585j;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                C1788s7 c1788s7 = (C1788s7) this.f16237b;
                if (view == c1788s7.f26294o && (message4 = c1788s7.f26296q) != null) {
                    message = Message.obtain(message4);
                } else if (view == c1788s7.f26298s && (message3 = c1788s7.f26300u) != null) {
                    message = Message.obtain(message3);
                } else if (view == c1788s7.f26302w && (message2 = c1788s7.f26304y) != null) {
                    message = Message.obtain(message2);
                } else {
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                c1788s7.f26278P.obtainMessage(1, c1788s7.f26281b).sendToTarget();
                return;
            case 3:
                Fragment fragment = (ErrorFragment) this.f16237b;
                FragmentManager supportFragmentManager = fragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager != null) {
                    supportFragmentManager.beginTransaction().remove(fragment).commit();
                    return;
                }
                return;
            case 4:
                OnboardingFragment onboardingFragment = (OnboardingFragment) this.f16237b;
                if (onboardingFragment.f5054k) {
                    if (onboardingFragment.f5056m == onboardingFragment.getPageCount() - 1) {
                        onboardingFragment.onFinishFragment();
                        return;
                    } else {
                        onboardingFragment.moveToNextPage();
                        return;
                    }
                }
                return;
            case 5:
                OnboardingSupportFragment onboardingSupportFragment = (OnboardingSupportFragment) this.f16237b;
                if (onboardingSupportFragment.f5089o0) {
                    if (onboardingSupportFragment.f5091q0 == onboardingSupportFragment.getPageCount() - 1) {
                        onboardingSupportFragment.onFinishFragment();
                        return;
                    } else {
                        onboardingSupportFragment.moveToNextPage();
                        return;
                    }
                }
                return;
            case 6:
                C0413z1 c0413z1 = (C0413z1) this.f16237b;
                c0413z1.f6450n = !c0413z1.f6450n;
                c0413z1.m1503d(c0413z1.f6337d);
                return;
            case 7:
                SearchBar searchBar = (SearchBar) this.f16237b;
                if (searchBar.f6149x) {
                    searchBar.stopRecognition();
                    return;
                } else {
                    searchBar.startRecognition();
                    return;
                }
            case 8:
                ((Toolbar) this.f16237b).collapseActionView();
                return;
            default:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.f16237b;
                CheckedTextView checkedTextView = trackSelectionView.f12305c;
                HashMap hashMap = trackSelectionView.f12309g;
                boolean z2 = true;
                if (view == checkedTextView) {
                    trackSelectionView.f12314l = true;
                    hashMap.clear();
                } else if (view == trackSelectionView.f12306d) {
                    trackSelectionView.f12314l = false;
                    hashMap.clear();
                } else {
                    trackSelectionView.f12314l = false;
                    gv2 gv2Var = (gv2) Assertions.checkNotNull(view.getTag());
                    TrackGroup mediaTrackGroup = gv2Var.f17850a.getMediaTrackGroup();
                    TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(mediaTrackGroup);
                    int i = gv2Var.f17851b;
                    if (trackSelectionOverride == null) {
                        if (!trackSelectionView.f12311i && hashMap.size() > 0) {
                            hashMap.clear();
                        }
                        hashMap.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, ImmutableList.m3903of(Integer.valueOf(i))));
                    } else {
                        ArrayList arrayList = new ArrayList(trackSelectionOverride.trackIndices);
                        boolean isChecked = ((CheckedTextView) view).isChecked();
                        Tracks.Group group = gv2Var.f17850a;
                        if (trackSelectionView.f12310h && group.isAdaptiveSupported()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z && (!trackSelectionView.f12311i || trackSelectionView.f12308f.size() <= 1)) {
                            z2 = false;
                        }
                        if (isChecked && z2) {
                            arrayList.remove(Integer.valueOf(i));
                            if (arrayList.isEmpty()) {
                                hashMap.remove(mediaTrackGroup);
                            } else {
                                hashMap.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, arrayList));
                            }
                        } else if (!isChecked) {
                            if (z) {
                                arrayList.add(Integer.valueOf(i));
                                hashMap.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, arrayList));
                            } else {
                                hashMap.put(mediaTrackGroup, new TrackSelectionOverride(mediaTrackGroup, ImmutableList.m3903of(Integer.valueOf(i))));
                            }
                        }
                    }
                }
                trackSelectionView.m2955a();
                TrackSelectionView.TrackSelectionListener trackSelectionListener = trackSelectionView.f12316n;
                if (trackSelectionListener != null) {
                    trackSelectionListener.onTrackSelectionChanged(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
                    return;
                }
                return;
        }
    }
}
