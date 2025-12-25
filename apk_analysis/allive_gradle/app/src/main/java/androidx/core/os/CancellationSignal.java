package androidx.core.os;

import androidx.annotation.Nullable;

@Deprecated
/* loaded from: classes.dex */
public final class CancellationSignal {

    /* renamed from: a */
    public boolean f3704a;

    /* renamed from: b */
    public OnCancelListener f3705b;

    /* renamed from: c */
    public android.os.CancellationSignal f3706c;

    /* renamed from: d */
    public boolean f3707d;

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    public void cancel() {
        synchronized (this) {
            try {
                if (this.f3704a) {
                    return;
                }
                this.f3704a = true;
                this.f3707d = true;
                OnCancelListener onCancelListener = this.f3705b;
                android.os.CancellationSignal cancellationSignal = this.f3706c;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f3707d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
                synchronized (this) {
                    this.f3707d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        android.os.CancellationSignal cancellationSignal;
        synchronized (this) {
            try {
                if (this.f3706c == null) {
                    android.os.CancellationSignal cancellationSignal2 = new android.os.CancellationSignal();
                    this.f3706c = cancellationSignal2;
                    if (this.f3704a) {
                        cancellationSignal2.cancel();
                    }
                }
                cancellationSignal = this.f3706c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellationSignal;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f3704a;
        }
        return z;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            while (this.f3707d) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f3705b == onCancelListener) {
                return;
            }
            this.f3705b = onCancelListener;
            if (this.f3704a && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if (!isCanceled()) {
        } else {
            throw new OperationCanceledException();
        }
    }
}
