package RexProf.Controller;

import RexProf.Service.GroupsService.IGroupsService;
import RexProf.modelDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Groups")
@RestController
public class GroupsController {
    @Autowired
    IGroupsService groupsService;
    @RequestMapping(value = "/getNBRGroup", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRGroup() {
        return groupsService.getNBRGroup();
    }
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addGroup(@RequestBody GroupsDto g) { groupsService.addGroup(g); }
    @RequestMapping(value = "/getGroups", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<GroupsDto> getGroups() {
        return groupsService.getAllGroups();
    }
    @RequestMapping(value = "/getGroupID", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public GroupsDto getUserID(@RequestParam("id") long id) {
        return groupsService.getGroup(id);
    }
    @RequestMapping(value = "/Change", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Change
            (@RequestParam("id") long id)
    {
        groupsService.change(id);
    }
    @RequestMapping(value = "/deleteGroup", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteGroup(@RequestParam("id") long id) {
        groupsService.deleteGroupes(id);
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void ModifierGroup(
            @RequestBody GroupsDto c
    )  {
        groupsService.UpdateGroupes(c);
    }
    @RequestMapping(value = "/getNBRGroupA", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRGroupA() {
        return groupsService.getNBRGroupA();
    }
    @RequestMapping(value = "/getNBRGroupD", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRGroupD() {
        return groupsService.getNBRGroupD();
    }

    @RequestMapping(value = "/affectation", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addGroup(@RequestBody GroupsRoleDto g) { groupsService.affectation(g); }
    @RequestMapping(value = "/getidgroup", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public GroupsDto getidgroup(@RequestParam("id") long id) {
        return groupsService.getidgroup(id);
    }
}

