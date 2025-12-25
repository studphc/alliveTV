package p000;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.hisona.allive.GlideRequests;

/* loaded from: classes.dex */
public final class pw0 implements RequestManagerRetriever.RequestManagerFactory {
    @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
    public final RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        return new GlideRequests(glide, lifecycle, requestManagerTreeNode, context);
    }
}
