package id.vincenttp.ajaibtest.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoriesResponse(
    @Json(name = "id") var id: Int?,
    @Json(name = "node_id") var nodeId: String?,
    @Json(name = "name") var name: String?,
    @Json(name = "full_name") var fullName: String?,
    @Json(name = "private") var private: Boolean?,
    @Json(name = "owner") var owner: Owner?,
    @Json(name = "html_url") var htmlUrl: String?,
    @Json(name = "description") var description: String?,
    @Json(name = "fork") var fork: Boolean?,
    @Json(name = "url") var url: String?,
    @Json(name = "forks_url") var forksUrl: String?,
    @Json(name = "keys_url") var keysUrl: String?,
    @Json(name = "collaborators_url") var collaboratorsUrl: String?,
    @Json(name = "teams_url") var teamsUrl: String?,
    @Json(name = "hooks_url") var hooksUrl: String?,
    @Json(name = "issue_events_url") var issueEventsUrl: String?,
    @Json(name = "events_url") var eventsUrl: String?,
    @Json(name = "assignees_url") var assigneesUrl: String?,
    @Json(name = "branches_url") var branchesUrl: String?,
    @Json(name = "tags_url") var tagsUrl: String?,
    @Json(name = "blobs_url") var blobsUrl: String?,
    @Json(name = "git_tags_url") var gitTagsUrl: String?,
    @Json(name = "git_refs_url") var gitRefsUrl: String?,
    @Json(name = "trees_url") var treesUrl: String?,
    @Json(name = "statuses_url") var statusesUrl: String?,
    @Json(name = "languages_url") var languagesUrl: String?,
    @Json(name = "stargazers_url") var stargazersUrl: String?,
    @Json(name = "contributors_url") var contributorsUrl: String?,
    @Json(name = "subscribers_url") var subscribersUrl: String?,
    @Json(name = "subscription_url") var subscriptionUrl: String?,
    @Json(name = "commits_url") var commitsUrl: String?,
    @Json(name = "git_commits_url") var gitCommitsUrl: String?,
    @Json(name = "comments_url") var commentsUrl: String?,
    @Json(name = "issue_comment_url") var issueCommentUrl: String?,
    @Json(name = "contents_url") var contentsUrl: String?,
    @Json(name = "compare_url") var compareUrl: String?,
    @Json(name = "merges_url") var mergesUrl: String?,
    @Json(name = "archive_url") var archiveUrl: String?,
    @Json(name = "downloads_url") var downloadsUrl: String?,
    @Json(name = "issues_url") var issuesUrl: String?,
    @Json(name = "pulls_url") var pullsUrl: String?,
    @Json(name = "milestones_url") var milestonesUrl: String?,
    @Json(name = "notifications_url") var notificationsUrl: String?,
    @Json(name = "labels_url") var labelsUrl: String?,
    @Json(name = "releases_url") var releasesUrl: String?,
    @Json(name = "deployments_url") var deploymentsUrl: String?,
    @Json(name = "created_at") var createdAt: String?,
    @Json(name = "updated_at") var updatedAt: String?,
    @Json(name = "pushed_at") var pushedAt: String?,
    @Json(name = "git_url") var gitUrl: String?,
    @Json(name = "ssh_url") var sshUrl: String?,
    @Json(name = "clone_url") var cloneUrl: String?,
    @Json(name = "svn_url") var svnUrl: String?,
    @Json(name = "homepage") var homepage: String?,
    @Json(name = "size") var size: Int?,
    @Json(name = "stargazers_count") var stargazersCount: Int?,
    @Json(name = "watchers_count") var watchersCount: Int?,
    @Json(name = "language") var language: String?,
    @Json(name = "has_issues") var hasIssues: Boolean?,
    @Json(name = "has_projects") var hasProjects: Boolean?,
    @Json(name = "has_downloads") var hasDownloads: Boolean?,
    @Json(name = "has_wiki") var hasWiki: Boolean?,
    @Json(name = "has_pages") var hasPages: Boolean?,
    @Json(name = "forks_count") var forksCount: Int?,
    @Json(name = "mirror_url") var mirrorUrl: String?,
    @Json(name = "archived") var archived: Boolean?,
    @Json(name = "disabled") var disabled: Boolean?,
    @Json(name = "open_issues_count") var openIssuesCount: Int?,
    @Json(name = "license") var license: License?,
    @Json(name = "allow_forking") var allowForking: Boolean?,
    @Json(name = "is_template") var isTemplate: Boolean?,
    @Json(name = "web_commit_signoff_required") var webCommitSignoffRequired: Boolean?,
    @Json(name = "topics") var topics: List<String> = listOf(),
    @Json(name = "visibility") var visibility: String?,
    @Json(name = "forks") var forks: Int?,
    @Json(name = "open_issues") var openIssues: Int?,
    @Json(name = "watchers") var watchers: Int?,
    @Json(name = "default_branch") var defaultBranch: String
) {
    data class Owner(

        @Json(name = "login") var login: String?,
        @Json(name = "id") var id: Int?,
        @Json(name = "node_id") var nodeId: String?,
        @Json(name = "avatar_url") var avatarUrl: String?,
        @Json(name = "gravatar_id") var gravatarId: String?,
        @Json(name = "url") var url: String?,
        @Json(name = "html_url") var htmlUrl: String?,
        @Json(name = "followers_url") var followersUrl: String?,
        @Json(name = "following_url") var followingUrl: String?,
        @Json(name = "gists_url") var gistsUrl: String?,
        @Json(name = "starred_url") var starredUrl: String?,
        @Json(name = "subscriptions_url") var subscriptionsUrl: String?,
        @Json(name = "organizations_url") var organizationsUrl: String?,
        @Json(name = "repos_url") var reposUrl: String?,
        @Json(name = "events_url") var eventsUrl: String?,
        @Json(name = "received_events_url") var receivedEventsUrl: String?,
        @Json(name = "type") var type: String?,
        @Json(name = "site_admin") var siteAdmin: Boolean

    )

    data class License(

        @Json(name = "key") var key: String?,
        @Json(name = "name") var name: String?,
        @Json(name = "spdx_id") var spdxId: String?,
        @Json(name = "url") var url: String?,
        @Json(name = "node_id") var nodeId: String

    )
}