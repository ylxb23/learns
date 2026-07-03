//package com.zero.learns.spring;
//
//import org.springframework.boot.availability.*;
//
//public class ApplicationAvailabilityHere implements ApplicationAvailability {
//    @Override
//    public LivenessState getLivenessState() {
//        return ApplicationAvailability.super.getLivenessState();
//    }
//
//    @Override
//    public ReadinessState getReadinessState() {
//        return ApplicationAvailability.super.getReadinessState();
//    }
//
//    @Override
//    public <S extends AvailabilityState> S getState(Class<S> stateType, S defaultState) {
//        return null;
//    }
//
//    @Override
//    public <S extends AvailabilityState> S getState(Class<S> stateType) {
//        return null;
//    }
//
//    @Override
//    public <S extends AvailabilityState> AvailabilityChangeEvent<S> getLastChangeEvent(Class<S> stateType) {
//        return null;
//    }
//}
