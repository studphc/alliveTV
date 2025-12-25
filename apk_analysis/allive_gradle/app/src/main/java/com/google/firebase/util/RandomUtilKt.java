package com.google.firebase.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1204fq;
import p000.r82;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m5569d2 = {"Lkotlin/random/Random;", "", "length", "", "nextAlphanumericString", "(Lkotlin/random/Random;I)Ljava/lang/String;", "com.google.firebase-firebase-common"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nRandomUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RandomUtil.kt\ncom/google/firebase/util/RandomUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1#2:43\n1549#3:44\n1620#3,3:45\n*S KotlinDebug\n*F\n+ 1 RandomUtil.kt\ncom/google/firebase/util/RandomUtilKt\n*L\n34#1:44\n34#1:45,3\n*E\n"})
/* loaded from: classes2.dex */
public final class RandomUtilKt {
    @NotNull
    public static final String nextAlphanumericString(@NotNull Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        if (i >= 0) {
            IntRange until = r82.until(0, i);
            ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList.add(Character.valueOf(StringsKt___StringsKt.random("23456789abcdefghjkmnpqrstvwxyz", random)));
            }
            return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "invalid length: ").toString());
    }
}
