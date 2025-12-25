package kotlin.text;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1891v;
import p000.ph1;
import p000.r82;

@Metadata(m5568d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m5569d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Lkotlin/text/MatchGroup;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;)Lkotlin/text/MatchGroup;", "getSize", "()I", "size", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* renamed from: a */
    public final /* synthetic */ ph1 f21353a;

    public MatcherMatchResult$groups$1(ph1 ph1Var) {
        this.f21353a = ph1Var;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return contains((MatchGroup) obj);
        }
        return false;
    }

    @Override // kotlin.text.MatchGroupCollection
    @Nullable
    public MatchGroup get(int index) {
        IntRange until;
        ph1 ph1Var = this.f21353a;
        until = r82.until(r1.start(index), ph1Var.f25177a.end(index));
        if (until.getStart().intValue() < 0) {
            return null;
        }
        String group = ph1Var.f25177a.group(index);
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group(index)");
        return new MatchGroup(group, until);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int getF21007c() {
        return this.f21353a.f25177a.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<MatchGroup> iterator() {
        return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(CollectionsKt__CollectionsKt.getIndices(this)), new C1891v(7, this)).iterator();
    }

    public /* bridge */ boolean contains(MatchGroup matchGroup) {
        return super.contains((MatcherMatchResult$groups$1) matchGroup);
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    @Nullable
    public MatchGroup get(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(this.f21353a.f25177a, name);
    }
}
