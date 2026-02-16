package com.dotsdev.power

import android.content.Context
import com.dotsdev.power.internal.InferenceEngineImpl

/**
 * Main entry point for Arm's AI Chat library.
 */
object AiChat {
    /**
     * Get the inference engine single instance.
     */
    fun getInferenceEngine(context: Context) = InferenceEngineImpl.getInstance(context)
}