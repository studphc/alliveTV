package p000;

import android.content.res.Configuration;
import android.media.MediaCodec;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import io.reactivex.rxjava3.core.CompletableObserver;
import java.util.StringJoiner;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import org.reactivestreams.Subscriber;

/* renamed from: o3 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1608o3 {
    /* renamed from: B */
    public static /* bridge */ /* synthetic */ boolean m6410B(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isImportantForAccessibility();
    }

    /* renamed from: C */
    public static /* bridge */ /* synthetic */ boolean m6411C(Object obj) {
        return obj instanceof CompletionException;
    }

    /* renamed from: c */
    public static /* bridge */ /* synthetic */ int m6415c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getDrawingOrder();
    }

    /* renamed from: e */
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern m6417e() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* renamed from: f */
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern m6418f(int i, int i2) {
        return new MediaCodec.CryptoInfo.Pattern(i, i2);
    }

    /* renamed from: g */
    public static /* bridge */ /* synthetic */ LocaleList m6419g(Configuration configuration) {
        return configuration.getLocales();
    }

    /* renamed from: i */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m6421i() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ String m6422j(LocaleList localeList) {
        return localeList.toLanguageTags();
    }

    /* renamed from: m */
    public static /* synthetic */ StringJoiner m6425m() {
        return new StringJoiner(", ", "(one of: ", ")");
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ CompletionException m6426n(Object obj) {
        return (CompletionException) obj;
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ CompletionStage m6427o(CompletableObserver completableObserver) {
        return (CompletionStage) completableObserver;
    }

    /* renamed from: p */
    public static /* bridge */ /* synthetic */ CompletionStage m6428p(Subscriber subscriber) {
        return (CompletionStage) subscriber;
    }

    /* renamed from: q */
    public static /* synthetic */ void m6429q() {
    }

    /* renamed from: v */
    public static /* bridge */ /* synthetic */ void m6434v(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        accessibilityNodeInfo.setDrawingOrder(i);
    }

    /* renamed from: w */
    public static /* bridge */ /* synthetic */ void m6435w(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setImportantForAccessibility(z);
    }
}
