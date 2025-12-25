package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;

/* renamed from: com.bumptech.glide.manager.c */
/* loaded from: classes.dex */
public final class C0637c implements RequestManagerRetriever.RequestManagerFactory {
    @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
    public final RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
    }
}
