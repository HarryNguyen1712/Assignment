package AssignmentPart2.entities;

public final class Certificate {
    private String certificateID;
    private String certificateName;
    private String CertificateRank;
    private String CertificatedDate;

    public Certificate(String certificateID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificateID = certificateID;
        this.certificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
    }

    public Certificate() {
    }

    public String getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(String certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        CertificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        CertificatedDate = certificatedDate;
    }
}

