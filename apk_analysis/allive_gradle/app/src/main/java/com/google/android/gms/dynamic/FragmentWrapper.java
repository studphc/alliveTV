package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a */
    public final Fragment f13696a;

    public FragmentWrapper(Fragment fragment) {
        this.f13696a = fragment;
    }

    @Nullable
    @KeepForSdk
    public static FragmentWrapper wrap(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzA() {
        return this.f13696a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzb() {
        return this.f13696a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzc() {
        return this.f13696a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final Bundle zzd() {
        return this.f13696a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final IFragmentWrapper zze() {
        return wrap(this.f13696a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final IFragmentWrapper zzf() {
        return wrap(this.f13696a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.f13696a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.f13696a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.f13696a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final String zzj() {
        return this.f13696a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzk(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f13696a.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzl(boolean z) {
        this.f13696a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzm(boolean z) {
        this.f13696a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzn(boolean z) {
        this.f13696a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzo(boolean z) {
        this.f13696a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzp(@NonNull Intent intent) {
        this.f13696a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzq(@NonNull Intent intent, int i) {
        this.f13696a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzr(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f13696a.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.f13696a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzt() {
        return this.f13696a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzu() {
        return this.f13696a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzv() {
        return this.f13696a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzw() {
        return this.f13696a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzx() {
        return this.f13696a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzy() {
        return this.f13696a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzz() {
        return this.f13696a.isResumed();
    }
}
