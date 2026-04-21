package com.tesis.teamsoft.metaheuristics.objetives;

import com.tesis.teamsoft.persistence.entity.PersonEntity;
import com.tesis.teamsoft.persistence.entity.PersonTestEntity;
import com.tesis.teamsoft.metaheuristics.auxiliary.ProjectRole;
import com.tesis.teamsoft.metaheuristics.auxiliary.RoleWorker;
import com.tesis.teamsoft.persistence.entity.auxiliary.BelbinRole;
import problem.definition.ObjetiveFunction;
import problem.definition.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @author G1lb3rt
 */


public class MaximizeBelbinRoles extends ObjetiveFunction {

    public static String className = "RolesBelbin";


    @Override
    public Double Evaluation(State state) {

        List<Object> projects = state.getCode(); //obtener lista de proyectos -roles
        double sum = 0;
        double belbinProject;
        int i = 0;

        while (i < projects.size()) { //para cada projecto-rol
            ProjectRole projectRole = (ProjectRole) projects.get(i);
            List<RoleWorker> roleWorkers = projectRole.getRoleWorkers();

            List<PersonEntity> team = new ArrayList<>(); //listado de personas del projecto

            int j = 0;
            while (j < roleWorkers.size()) { //para cada rol-persona
                RoleWorker roleWorker = roleWorkers.get(j);
                team.addAll(roleWorker.getFixedWorkers());  // concatenar listas de personas y personas fijadas por el usuario
                team.addAll(roleWorker.getWorkers()); //añadir personas que juegan el rol actual a la lista de personas del proyecto

                j++;
            }

            int CE = 0;
            int ME = 0;
            int ES = 0;
            int ID = 0;
            int IS = 0;
            int FI = 0;
            int CO = 0;
            int CH = 0;
            int IR = 0;

            int k = 0;
            while (k < team.size()) {  //para cada persona del equipo de proyecto actual
                PersonEntity worker = team.get(k);
                PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas

                if (workerTest != null) {
                    if (workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E && ID != 1) {
                        ID = 1;
                    }
                    if (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E && IS != 1) {
                        IS = 1;
                    }
                    if (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E && FI != 1) {
                        FI = 1;
                    }
                    if (workerTest.getCE() != BelbinRole.I && workerTest.getCE() != BelbinRole.E && CE != 1) {
                        CE = 1;
                    }
                    if (workerTest.getME() != BelbinRole.I && workerTest.getME() != BelbinRole.E && ME != 1) {
                        ME = 1;
                    }
                    if (workerTest.getES() != BelbinRole.I && workerTest.getES() != BelbinRole.E && ES != 1) {
                        ES = 1;
                    }
                    if (workerTest.getCO() != BelbinRole.I && workerTest.getCO() != BelbinRole.E && CO != 1) {
                        CO = 1;
                    }
                    if (workerTest.getCH() != BelbinRole.I && workerTest.getCH() != BelbinRole.E && CH != 1) {
                        CH = 1;
                    }
                    if (workerTest.getIR() != BelbinRole.I && workerTest.getIR() != BelbinRole.E && IR != 1) {
                        IR = 1;
                    }
                }
                k++;
            }
            belbinProject = ID + IS + FI + CE + ME + ES + CO + CH + IR;
            sum += belbinProject;
            projectRole.getProjectEvaluation()[5] = belbinProject/9;
            i++;
        }

        sum = sum / (9 * projects.size());
        return sum;
    }

}
