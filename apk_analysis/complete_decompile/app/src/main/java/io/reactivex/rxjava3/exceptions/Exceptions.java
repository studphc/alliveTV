package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes2.dex */
public final class Exceptions {
    @NonNull
    public static RuntimeException propagate(@NonNull Throwable th) {
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public static void throwIfFatal(@NonNull Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (!(th instanceof LinkageError)) {
                    return;
                } else {
                    throw ((LinkageError) th);
                }
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
