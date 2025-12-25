package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
/* loaded from: classes.dex */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a */
    public final Fragment f13700a;

    public SupportFragmentWrapper(Fragment fragment) {
        this.f13700a = fragment;
    }

    @Nullable
    @KeepForSdk
    public static SupportFragmentWrapper wrap(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzA() {
        return this.f13700a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzb() {
        return this.f13700a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzc() {
        return this.f13700a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final Bundle zzd() {
        return this.f13700a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final IFragmentWrapper zze() {
        return wrap(this.f13700a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final IFragmentWrapper zzf() {
        return wrap(this.f13700a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.f13700a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.f13700a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @NonNull
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.f13700a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @Nullable
    public final String zzj() {
        return this.f13700a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzk(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f13700a.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzl(boolean z) {
        this.f13700a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzm(boolean z) {
        this.f13700a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzn(boolean z) {
        this.f13700a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzo(boolean z) {
        this.f13700a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzp(@NonNull Intent intent) {
        this.f13700a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzq(@NonNull Intent intent, int i) {
        this.f13700a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzr(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f13700a.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.f13700a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzt() {
        return this.f13700a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzu() {
        return this.f13700a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzv() {
        return this.f13700a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzw() {
        return this.f13700a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzx() {
        return this.f13700a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzy() {
        return this.f13700a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzz() {
        return this.f13700a.isResumed();
    }
}
