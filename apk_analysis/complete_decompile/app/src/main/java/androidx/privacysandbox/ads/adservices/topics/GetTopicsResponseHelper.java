package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1248gx;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\u0006¨\u0006\n"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponseHelper;", "", "Landroid/adservices/topics/GetTopicsResponse;", "response", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "convertResponse$ads_adservices_release", "(Landroid/adservices/topics/GetTopicsResponse;)Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "convertResponse", "convertResponseWithEncryptedTopics$ads_adservices_release", "convertResponseWithEncryptedTopics", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class GetTopicsResponseHelper {

    @NotNull
    public static final GetTopicsResponseHelper INSTANCE = new Object();

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @NotNull
    public final GetTopicsResponse convertResponse$ads_adservices_release(@NotNull android.adservices.topics.GetTopicsResponse response) {
        List topics;
        long taxonomyVersion;
        long modelVersion;
        int topicId;
        Intrinsics.checkNotNullParameter(response, "response");
        ArrayList arrayList = new ArrayList();
        topics = response.getTopics();
        Iterator it = topics.iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic m5014r = AbstractC1248gx.m5014r(it.next());
            taxonomyVersion = m5014r.getTaxonomyVersion();
            modelVersion = m5014r.getModelVersion();
            topicId = m5014r.getTopicId();
            arrayList.add(new Topic(taxonomyVersion, modelVersion, topicId));
        }
        return new GetTopicsResponse(arrayList);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 11), @RequiresExtension(extension = 31, version = 11)})
    @ExperimentalFeatures.Ext11OptIn
    @NotNull
    public final GetTopicsResponse convertResponseWithEncryptedTopics$ads_adservices_release(@NotNull android.adservices.topics.GetTopicsResponse response) {
        List topics;
        long taxonomyVersion;
        long modelVersion;
        int topicId;
        Intrinsics.checkNotNullParameter(response, "response");
        ArrayList arrayList = new ArrayList();
        topics = response.getTopics();
        Iterator it = topics.iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic m5014r = AbstractC1248gx.m5014r(it.next());
            taxonomyVersion = m5014r.getTaxonomyVersion();
            modelVersion = m5014r.getModelVersion();
            topicId = m5014r.getTopicId();
            arrayList.add(new Topic(taxonomyVersion, modelVersion, topicId));
        }
        ArrayList arrayList2 = new ArrayList();
        for (android.adservices.topics.EncryptedTopic encryptedTopic : response.getEncryptedTopics()) {
            byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
            Intrinsics.checkNotNullExpressionValue(encryptedTopic2, "encryptedTopic.encryptedTopic");
            String keyIdentifier = encryptedTopic.getKeyIdentifier();
            Intrinsics.checkNotNullExpressionValue(keyIdentifier, "encryptedTopic.keyIdentifier");
            byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
            Intrinsics.checkNotNullExpressionValue(encapsulatedKey, "encryptedTopic.encapsulatedKey");
            arrayList2.add(new EncryptedTopic(encryptedTopic2, keyIdentifier, encapsulatedKey));
        }
        return new GetTopicsResponse(arrayList, arrayList2);
    }
}
