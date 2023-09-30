package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        int sum = 0;
        for (int i = 0; i < members.length; i++) {
           Grade grade = gradeDB.getGrade(members[i],course);
           sum = sum + grade.getGrade();
        }
        return (float) sum /members.length;
    }
}
