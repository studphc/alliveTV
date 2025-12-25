package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.LinkedList;
import p000.ai2;
import p000.g83;
import p000.k73;
import p000.l83;
import p000.o83;
import p000.ou2;
import p000.z73;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* renamed from: a */
    public LifecycleDelegate f13692a;

    /* renamed from: b */
    public Bundle f13693b;

    /* renamed from: c */
    public LinkedList f13694c;

    /* renamed from: d */
    public final ai2 f13695d = new ai2(15, this);

    @KeepForSdk
    public DeferredLifecycleHelper() {
    }

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(@NonNull FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String zac = zac.zac(context, isGooglePlayServicesAvailable);
        String zab = zac.zab(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zac);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zab);
            linearLayout.addView(button);
            button.setOnClickListener(new ou2(context, errorResolutionIntent));
        }
    }

    /* renamed from: a */
    public final void m3203a(int i) {
        while (!this.f13694c.isEmpty() && ((o83) this.f13694c.getLast()).zaa() >= i) {
            this.f13694c.removeLast();
        }
    }

    /* renamed from: b */
    public final void m3204b(Bundle bundle, o83 o83Var) {
        if (this.f13692a != null) {
            o83Var.zab();
            return;
        }
        if (this.f13694c == null) {
            this.f13694c = new LinkedList();
        }
        this.f13694c.add(o83Var);
        if (bundle != null) {
            Bundle bundle2 = this.f13693b;
            if (bundle2 == null) {
                this.f13693b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f13695d);
    }

    @KeepForSdk
    public abstract void createDelegate(@NonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @NonNull
    @KeepForSdk
    public T getDelegate() {
        return (T) this.f13692a;
    }

    @KeepForSdk
    public void handleGooglePlayUnavailable(@NonNull FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @KeepForSdk
    public void onCreate(@Nullable Bundle bundle) {
        m3204b(bundle, new z73(this, bundle));
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m3204b(bundle, new g83(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f13692a == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void onDestroy() {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            m3203a(1);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroyView();
        } else {
            m3203a(2);
        }
    }

    @KeepForSdk
    public void onInflate(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2) {
        m3204b(bundle2, new k73(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
    }

    @KeepForSdk
    public void onPause() {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            m3203a(5);
        }
    }

    @KeepForSdk
    public void onResume() {
        m3204b(null, new l83(this, 1));
    }

    @KeepForSdk
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f13693b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onStart() {
        m3204b(null, new l83(this, 0));
    }

    @KeepForSdk
    public void onStop() {
        LifecycleDelegate lifecycleDelegate = this.f13692a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
        } else {
            m3203a(4);
        }
    }
}
