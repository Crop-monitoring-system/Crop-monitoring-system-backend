package lk.ijse.cropmonitoringsystembackend.enums;

public enum Status {
    ACTIVE,            // Currently in use or operational.
    INACTIVE,          // Not in use but still available.
    UNDER_MAINTENANCE, // Temporarily unavailable due to maintenance.
    RESERVED,          // Reserved for future use.
    RETIRED,           // Permanently out of use.
    DAMAGED,           // Not functional due to damage.
    AVAILABLE
}
