package com.tesis.teamsoft.metaheuristics.restrictions;

import com.tesis.teamsoft.persistence.entity.PersonEntity;
import com.tesis.teamsoft.persistence.entity.PersonTestEntity;
import com.tesis.teamsoft.persistence.entity.auxiliary.BelbinRole;
import metaheurictics.strategy.Strategy;
import com.tesis.teamsoft.metaheuristics.auxiliary.ProjectRole;
import com.tesis.teamsoft.metaheuristics.auxiliary.ProjectRoleState;
import com.tesis.teamsoft.metaheuristics.auxiliary.RoleWorker;
import com.tesis.teamsoft.metaheuristics.auxiliary.TeamFormationCodification;
import problem.definition.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Al menos una persona con rol mental, una con rol de accion, y una con rol
 * social (en el equipo).
 */
public class AllBelbinCategories extends Constrain {

    public AllBelbinCategories() {
    }

    @Override
    public Boolean ValidateState(State state) {

        List<Object> projects = state.getCode(); //obtener lista de proyectos -roles

        int i = 0;
        boolean meet = true;
        while (i < projects.size() && meet) { //para cada projecto-rol
            ProjectRole projectRole = (ProjectRole) projects.get(i);
            List<RoleWorker> roleWorkers = projectRole.getRoleWorkers();


            List<PersonEntity> team = new ArrayList<>(); //listado de personas del projecto

            int j = 0;
            while (j < roleWorkers.size()) { //para cada rol-persona
                RoleWorker roleWorker = roleWorkers.get(j);
                List<PersonEntity> aux = new ArrayList<>(); // concatenar listas de personas y personas fijadas por el usuario
                aux.addAll(roleWorker.getWorkers());
                aux.addAll(roleWorker.getFixedWorkers());

                team.addAll(aux); //añadir personas que juegan el rol actual a la lista de personas del proyecto

                j++;
            }
            meet = validateProject(team);
            i++;
        }
        return meet;

    }


    public void invalidateState(State state) {

        ProjectRoleState prState1 = new ProjectRoleState(state.getCode(), null, state.getTypeGenerator());
        ArrayList<Object> code = prState1.getCode();

        ProjectRole rp = ((ProjectRole) code.getFirst());
        for (int j = 0; j < rp.getRoleWorkers().size(); j++) {
            RoleWorker rw = rp.getRoleWorkers().get(j);
            for (int k = 0; k < rw.getWorkers().size(); k++) {

                PersonEntity worker = rw.getWorkers().get(k);
                PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas

                if (workerTest != null) {
                    //De este modo garantizo que en el primer proyecto no hayan roles de acción

                    if (workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E) {
                        ((ProjectRole) code.getFirst()).getRoleWorkers().get(j).getWorkers().get(k).getPersonTest().setIM(BelbinRole.I);
                    }
                    if (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E) {
                        ((ProjectRole) code.getFirst()).getRoleWorkers().get(j).getWorkers().get(k).getPersonTest().setIS(BelbinRole.I);
                    }
                    if (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E) {
                        ((ProjectRole) code.getFirst()).getRoleWorkers().get(j).getWorkers().get(k).getPersonTest().setIF(BelbinRole.I);
                    }
                }
            }
        }

    }


    public boolean validateProject(List<PersonEntity> team) {

        boolean mentalRoles = false;
        boolean actionRoles = false;
        boolean socialRoles = false;

        int k = 0;
        boolean meet = false;
        while (k < team.size() && !meet) {  //para cada persona del equipo de proyecto actual
            PersonEntity worker = team.get(k);
            PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas

            if (workerTest != null) {

                if ((workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E) || (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E) || (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E)) {
                    actionRoles = true;
                }
                if ((workerTest.getCE() != BelbinRole.I && workerTest.getCE() != BelbinRole.E) || (workerTest.getME() != BelbinRole.I && workerTest.getME() != BelbinRole.E) || (workerTest.getES() != BelbinRole.I && workerTest.getES() != BelbinRole.E)) {
                    mentalRoles = true;
                }
                if ((workerTest.getCO() != BelbinRole.I && workerTest.getCO() != BelbinRole.E) || (workerTest.getCH() != BelbinRole.I && workerTest.getCH() != BelbinRole.E) || (workerTest.getIR() != BelbinRole.I && workerTest.getIR() != BelbinRole.E)) {
                    socialRoles = true;
                }

                if (mentalRoles && actionRoles && socialRoles) {
                    meet = true;
                }
            }
            k++;
        }
        return meet;
    }

    public ArrayList<String> rolesQueHay(List<PersonEntity> team) {
        ArrayList<String> rolesQHay = new ArrayList<>();

        for (PersonEntity worker : team) {  //para cada persona del equipo de proyecto actual
            PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas

            if (workerTest != null) {

                if ((workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E) || (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E) || (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E)) {
                    rolesQHay.add("actionRoles");
                }
                if ((workerTest.getCE() != BelbinRole.I && workerTest.getCE() != BelbinRole.E) || (workerTest.getME() != BelbinRole.I && workerTest.getME() != BelbinRole.E) || (workerTest.getES() != BelbinRole.I && workerTest.getES() != BelbinRole.E)) {
                    rolesQHay.add("mentalRoles");

                }
                if ((workerTest.getCO() != BelbinRole.I && workerTest.getCO() != BelbinRole.E) || (workerTest.getCH() != BelbinRole.I && workerTest.getCH() != BelbinRole.E) || (workerTest.getIR() != BelbinRole.I && workerTest.getIR() != BelbinRole.E)) {
                    rolesQHay.add("socialRoles");
                }
            }
        }
        return rolesQHay;
    }

    public void RepareState(State state, List<PersonEntity> team, int posProy) {

        ArrayList<String> rolesQHay = rolesQueHay(team);

        ProjectRoleState prState1 = new ProjectRoleState(state.getCode(), null, state.getTypeGenerator());
        ArrayList<Object> code = prState1.getCode();


        ArrayList<PersonEntity> candidatos = new ArrayList<>();

        ArrayList<String> debenHaber = new ArrayList<String>() {{
            add("actionRoles");
            add("mentalRoles");
            add("socialRoles");
        }};

        ArrayList<String> rolesFaltan = new ArrayList<>();
        ArrayList<String> rolesRepetidos = new ArrayList<>();

        for (int i = 0; i < debenHaber.size(); i++) {
            int c = 0;
            for (String s : rolesQHay) {
                if (debenHaber.get(i).equals(s)) {
                    c++;
                }
                if (c > 1)
                    rolesRepetidos.add(rolesQHay.get(i));
            }
            if (c == 0) {
                rolesFaltan.add(rolesQHay.get(i));
            }
        }

        if (!rolesFaltan.isEmpty()) {
            candidatos = candidatos(rolesFaltan);

        }
        //tienen que haber candidatos suficientes para reparar la solucion y roles repetidos suficientes para sustituir
        if (candidatos.size() >= rolesFaltan.size() && rolesRepetidos.size() >= rolesFaltan.size()) {
            repareProjectSolution(state, posProy, rolesRepetidos, candidatos);

        }

    }

    public ArrayList<PersonEntity> candidatos(ArrayList<String> rolesFaltan) {
        TeamFormationCodification codification = (TeamFormationCodification) Strategy.getStrategy().getProblem().getCodification();
        ArrayList<PersonEntity> candidatos = new ArrayList<>();

        int i = 0;
        while (i < codification.getSearchArea().size() && (candidatos.size() < rolesFaltan.size())) {

            PersonEntity worker = codification.getSearchArea().get(i);
            PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas

            for (String s : rolesFaltan) {
                switch (s) {
                    case "actionRoles":
                        if ((workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E) || (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E) || (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E)) {
                            candidatos.add(worker);
                        }
                        break;
                    case "mentalRoles":
                        if ((workerTest.getCE() != BelbinRole.I && workerTest.getCE() != BelbinRole.E) || (workerTest.getME() != BelbinRole.I && workerTest.getME() != BelbinRole.E) || (workerTest.getES() != BelbinRole.I && workerTest.getES() != BelbinRole.E)) {
                            candidatos.add(worker);
                        }
                        break;
                    case "socialRoles":
                        if ((workerTest.getCO() != BelbinRole.I && workerTest.getCO() != BelbinRole.E) || (workerTest.getCH() != BelbinRole.I && workerTest.getCH() != BelbinRole.E) || (workerTest.getIR() != BelbinRole.I && workerTest.getIR() != BelbinRole.E)) {
                            candidatos.add(worker);
                        }
                        break;
                }
            }
            i++;
        }
        return candidatos;
    }

    public void repareProjectSolution(State state, int posProy, ArrayList<String> rolesRepetidos, ArrayList<PersonEntity> candidatos) {

        ProjectRole projectRole = (ProjectRole) state.getCode().get(posProy);
        List<RoleWorker> roleWorkers = projectRole.getRoleWorkers();
        int j = 0;
        while (j < roleWorkers.size() && !candidatos.isEmpty()) {
            RoleWorker rw = roleWorkers.get(j);
            for (int k = 0; k < rw.getWorkers().size(); k++) {
                PersonEntity worker = rw.getWorkers().get(k);
                PersonTestEntity workerTest = worker.getPersonTest(); //obtener caracteristicas psicologicas
                int a = 0;
                while (a < rolesRepetidos.size() && !candidatos.isEmpty()) {
                    switch (rolesRepetidos.get(a)) {
                        case "actionRoles":
                            if ((workerTest.getIM() != BelbinRole.I && workerTest.getIM() != BelbinRole.E) || (workerTest.getIS() != BelbinRole.I && workerTest.getIS() != BelbinRole.E) || (workerTest.getIF() != BelbinRole.I && workerTest.getIF() != BelbinRole.E)) {
                                ((ProjectRole) state.getCode().get(posProy)).getRoleWorkers().get(j).getWorkers().set(k, candidatos.removeFirst());
                            }
                            break;
                        case "mentalRoles":
                            if ((workerTest.getCE() != BelbinRole.I && workerTest.getCE() != BelbinRole.E) || (workerTest.getME() != BelbinRole.I && workerTest.getME() != BelbinRole.E) || (workerTest.getES() != BelbinRole.I && workerTest.getES() != BelbinRole.E)) {
                                ((ProjectRole) state.getCode().get(posProy)).getRoleWorkers().get(j).getWorkers().set(k, candidatos.removeFirst());
                            }
                            break;
                        case "socialRoles":
                            if ((workerTest.getCO() != BelbinRole.I && workerTest.getCO() != BelbinRole.E) || (workerTest.getCH() != BelbinRole.I && workerTest.getCH() != BelbinRole.E) || (workerTest.getIR() != BelbinRole.I && workerTest.getIR() != BelbinRole.E)) {
                                ((ProjectRole) state.getCode().get(posProy)).getRoleWorkers().get(j).getWorkers().set(k, candidatos.removeFirst());
                            }
                            break;
                    }
                    a++;
                }
            }
            j++;
        }

    }
}
