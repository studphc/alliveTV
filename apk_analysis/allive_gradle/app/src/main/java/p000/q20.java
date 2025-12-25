package p000;

import android.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.OnboardingFragment;
import androidx.leanback.app.OnboardingSupportFragment;

/* loaded from: classes.dex */
public final class q20 implements View.OnKeyListener {

    /* renamed from: a */
    public final /* synthetic */ int f25413a;

    /* renamed from: b */
    public final /* synthetic */ Object f25414b;

    public /* synthetic */ q20(int i, Object obj) {
        this.f25413a = i;
        this.f25414b = obj;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (this.f25413a) {
            case 0:
                DetailsFragment detailsFragment = (DetailsFragment) this.f25414b;
                Fragment fragment = detailsFragment.f4912R;
                if (fragment != null && fragment.getView() != null && detailsFragment.f4912R.getView().hasFocus() && ((i == 4 || i == 111) && detailsFragment.m1287c().getChildCount() > 0)) {
                    detailsFragment.m1287c().requestFocus();
                    return true;
                }
                return false;
            case 1:
                DetailsSupportFragment detailsSupportFragment = (DetailsSupportFragment) this.f25414b;
                androidx.fragment.app.Fragment fragment2 = detailsSupportFragment.f4953V0;
                if (fragment2 != null && fragment2.getView() != null && detailsSupportFragment.f4953V0.getView().hasFocus() && ((i == 4 || i == 111) && detailsSupportFragment.getVerticalGridView().getChildCount() > 0)) {
                    detailsSupportFragment.getVerticalGridView().requestFocus();
                    return true;
                }
                return false;
            case 2:
                OnboardingFragment onboardingFragment = (OnboardingFragment) this.f25414b;
                if (!onboardingFragment.f5054k) {
                    if (i == 4) {
                        return false;
                    }
                } else {
                    if (keyEvent.getAction() == 0) {
                        return false;
                    }
                    if (i != 4) {
                        if (i != 21) {
                            if (i != 22) {
                                return false;
                            }
                            if (onboardingFragment.f5052i) {
                                onboardingFragment.moveToNextPage();
                            } else {
                                onboardingFragment.moveToPreviousPage();
                            }
                        } else if (onboardingFragment.f5052i) {
                            onboardingFragment.moveToPreviousPage();
                        } else {
                            onboardingFragment.moveToNextPage();
                        }
                    } else {
                        if (onboardingFragment.f5056m == 0) {
                            return false;
                        }
                        onboardingFragment.moveToPreviousPage();
                    }
                }
                return true;
            default:
                OnboardingSupportFragment onboardingSupportFragment = (OnboardingSupportFragment) this.f25414b;
                if (!onboardingSupportFragment.f5089o0) {
                    if (i == 4) {
                        return false;
                    }
                } else {
                    if (keyEvent.getAction() == 0) {
                        return false;
                    }
                    if (i != 4) {
                        if (i != 21) {
                            if (i != 22) {
                                return false;
                            }
                            if (onboardingSupportFragment.f5087m0) {
                                onboardingSupportFragment.moveToNextPage();
                            } else {
                                onboardingSupportFragment.moveToPreviousPage();
                            }
                        } else if (onboardingSupportFragment.f5087m0) {
                            onboardingSupportFragment.moveToPreviousPage();
                        } else {
                            onboardingSupportFragment.moveToNextPage();
                        }
                    } else {
                        if (onboardingSupportFragment.f5091q0 == 0) {
                            return false;
                        }
                        onboardingSupportFragment.moveToPreviousPage();
                    }
                }
                return true;
        }
    }
}
