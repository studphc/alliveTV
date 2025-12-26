package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.exoplayer2.util.MimeTypes;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, m5569d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", MimeTypes.BASE_TYPE_TEXT, "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
/* loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {

    /* renamed from: a */
    public final /* synthetic */ Function1 f4085a;

    /* renamed from: b */
    public final /* synthetic */ Function4 f4086b;

    /* renamed from: c */
    public final /* synthetic */ Function4 f4087c;

    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, Unit> function1, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42) {
        this.f4085a = function1;
        this.f4086b = function4;
        this.f4087c = function42;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s) {
        this.f4085a.invoke(s);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        this.f4086b.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        this.f4087c.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
    }
}
