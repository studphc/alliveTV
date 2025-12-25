package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m5569d2 = {"Lkotlin/text/RegexOption;", "", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Enum;)Ljava/lang/Boolean;", "<anonymous>"}, m5570k = 3, m5571mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt$fromInt$1$1\n*L\n1#1,398:1\n*E\n"})
/* loaded from: classes2.dex */
public final class RegexKt$fromInt$1$1 extends Lambda implements Function1<Enum<Object>, Boolean> {

    /* renamed from: b */
    public final /* synthetic */ int f21357b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$1$1(int i) {
        super(1);
        this.f21357b = i;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Enum<Object> r3) {
        RegexOption regexOption = (RegexOption) r3;
        return Boolean.valueOf((regexOption.getMask() & this.f21357b) == regexOption.getValue());
    }
}
