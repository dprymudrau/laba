package com.solvd.airport.binary;

import java.util.Objects;

public class PilotInFlight {

    private long idPilotInFlight;
    private long pilotId;
    private long flightId;

    public long getIdPilotInFlight() {
        return idPilotInFlight;
    }

    public void setIdPilotInFlight(long idPilotInFlight) {
        this.idPilotInFlight = idPilotInFlight;
    }

    public long getPilotId() {
        return pilotId;
    }

    public void setPilotId(long pilotId) {
        this.pilotId = pilotId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotInFlight that = (PilotInFlight) o;
        return idPilotInFlight == that.idPilotInFlight && pilotId == that.pilotId && flightId == that.flightId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPilotInFlight, pilotId, flightId);
    }

    @Override
    public String toString() {
        return "PilotInFlight{" +
                "idPilotInFlight=" + idPilotInFlight +
                ", pilotId=" + pilotId +
                ", flightId=" + flightId +
                '}';
    }
}
