package p000;

import android.util.CloseGuard;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.Flow;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* renamed from: p3 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1673p3 {
    /* renamed from: B */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m6801B() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
    }

    /* renamed from: c */
    public static /* synthetic */ CloseGuard m6806c() {
        return new CloseGuard();
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ CloseGuard m6807d(Object obj) {
        return (CloseGuard) obj;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m6808e() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
    }

    /* renamed from: g */
    public static /* bridge */ /* synthetic */ Flow.Processor m6810g(Processor processor) {
        return (Flow.Processor) processor;
    }

    /* renamed from: h */
    public static /* bridge */ /* synthetic */ Flow.Publisher m6811h(Publisher publisher) {
        return (Flow.Publisher) publisher;
    }

    /* renamed from: i */
    public static /* bridge */ /* synthetic */ Flow.Subscriber m6812i(Subscriber subscriber) {
        return (Flow.Subscriber) subscriber;
    }

    /* renamed from: x */
    public static /* bridge */ /* synthetic */ boolean m6827x(Processor processor) {
        return processor instanceof Flow.Processor;
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m6828y(Publisher publisher) {
        return publisher instanceof Flow.Publisher;
    }

    /* renamed from: z */
    public static /* bridge */ /* synthetic */ boolean m6829z(Subscriber subscriber) {
        return subscriber instanceof Flow.Subscriber;
    }
}
